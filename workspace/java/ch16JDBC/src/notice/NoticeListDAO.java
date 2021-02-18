/*
 * 공지사항 리스트 - 전체, 현재, 지난, 예약
 */
package notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoticeListDAO {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 필요한 객체 선언 - select : con, pstmt, rs
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// DB 접속 정보
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "java00";
		String pw = "java00";
		
		// 결과로 나온 데이터 선언 - select : List<NoticeVO>
		List<NoticeVO> list = null;
		
		// 페이지 처리를 위한 변수 : 1페이지에 해당되는 데이터로 셋팅
		long startRow = 1;
		long endRow = 10;
		
		// 공지 쿼리 뒤에 붙는 조건문
		String condition = "";
		
		// 공지 리스트의 종류 선택 - 입력
		while(true) {
			System.out.println("<< 공지 리스트 종류 선택 >>");
			System.out.println("1. 전체공지  2. 현재공지  3. 지난공지  4. 예약공지");
			System.out.print("공지 선택(1~4) -> ");
			String menu = scanner.nextLine();
			
			if(menu.equals("1")) {
				// 조건이 없으면 전체 공지가 된다.
				break;
			} else if (menu.equals("2")) {
				// 현재 공지 - 현재 날짜가 공지 시작일과 종료일 사이에 있다.
				condition = " WHERE startDate < SYSDATE AND endDate > TRUNC(SYSDATE) ";
				break;
			} else if (menu.equals("3")) {
				// 지난 공지 - 종료일이 현재 날짜보다 작다.
				condition = " WHERE endDate < TRUNC(SYSDATE) ";
				break;
			} else if (menu.equals("4")) {
				// 예약공지 - 시작일이 현재 날짜보다 크다.
				condition = " WHERE startDate > SYSDATE ";
				break;
			} else System.out.println("잘못된 공지의 종류를 선택하셨습니다.");
		} // end of while(true)
		
		System.out.println("공지사항 처리를 위한 조건문 : " + condition);
		
		// 선택되어진 데이터 가져오기
		try { // 정상처리 : 1~6
			//1. 확인
			Class.forName(driver);
			System.out.println("++--- 드라이버 확인 완료");
			//2. 연결
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("++--- 연결 완료");
			//3. 쿼리 작성
			// 1) 원본 데이터 가져오기
			String sql = " SELECT no, title, startDate, endDate, updateDate FROM notice " + condition
					+ " ORDER BY startDate DESC ";
			// 2) 가져온 원본 데이터에 순서번호 붙이기(ROWNUM rnum)
			sql = " SELECT ROWNUM rnum, no, title, startDate, endDate, updateDate FROM ( " + sql + " ) ";
			// 3) 순서번호를 붙인 데이터에서 페이지에 맞는 데이터 가져오기.
			sql = " SELECT rnum, no, title, TO_CHAR(startDate , 'yyyy.mm.dd') startDate, "
					+ " TO_CHAR(endDate, 'yyyy.mm.dd') endDate, TO_CHAR(updateDate, 'yyyy.mm.dd') updateDate "
					+ "FROM ( " + sql + " ) "
					+ " WHERE rnum BETWEEN ? AND ?"; // 페이지 조건
			System.out.println("sql : " + sql);
			
			//4. 실행객체 & 데이터 셋팅
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, startRow);
			pstmt.setLong(2, endRow);
			System.out.println("++--- 실행객체 생성 & 데이터 셋팅 완료");
			
			//5. 실행
			// select : pstmt.executeQuery() - 결과 : ResultSet
			// insert, update, delete : pstmt.executeUpdate() - 결과 : int
			rs = pstmt.executeQuery();
			System.out.println("++--- 실행 완료");
			
			//6. 출력 (list -> 출력) - 데이터가 여러개 : 반복문
			// 1) 데이터를 list에 담기
			if(rs != null) { // 결과 저장 객체가 null이 아니다.
				while(rs.next()) { // 다음 데이터가 있으면 반복 처리
					// rs -> vo로 데이터 담기 -> list에 담는다.
					// 데이터를 담기 위해서 list가 null 이면 안된다. : 한번만 생성 - 생성이 안되어 있으면 생성한다.
					if(list == null) list = new ArrayList<NoticeVO>();
					NoticeVO vo = new NoticeVO(); // 생성한 후 저장한다.
					// rs에서 꺼내서 vo에 담기
					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setStartDate(rs.getString("startDate"));
					vo.setEndDate(rs.getString("endDate"));
					vo.setUpdateDate(rs.getString("updateDate"));
					// vo -> list
					list.add(vo);
				} // end of while(rs.next())
				// 데이터 확인
				System.out.println("DB에서 가져온 데이터 확인 : " + list);
			} // end of if(rs != null)
			
			// 2) list에 있는 데이터 출력하기
			System.out.println("+--------------------------------------------------------------+");
			System.out.println("+   번호    /         제목           /   공지시작일  /  공지 종료일  / 최종수정일   +");
			System.out.println("+--------------------------------------------------------------+");
			// 데이터가 없는 경우의 처리 - list가 null이 나온다.
			if(list == null) // 데이터가 없다.
				System.out.println("+  데이터가 존재하지 않습니다.");
			else { // 데이터가 있다. -> 있는 데이터를 출력하자.
				// 데이터가 있는 만큼 향상된 for
				for(NoticeVO vo : list) {
					System.out.print("+ " + vo.getNo());
					System.out.print(" / " + vo.getTitle());
					System.out.print(" / " + vo.getStartDate());
					System.out.print(" / " + vo.getEndDate());
					System.out.print(" / " + vo.getUpdateDate());
					System.out.println(); // 줄바꿈.
				}
			}
			System.out.println("+--------------------------------------------------------------+");
			System.out.println("++--- 데이터 출력 완료 ");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { //7. 닫기
				if(con != null) con.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
				System.out.println("++--- 닫기 완료");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
