/*
 * 공지사항 글보기 - 보여줄 글번호 입력 -> 데이터를 가져와서 출력
 */
package notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class NoticeViewDAO {

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
		
		// 결과로 나온 데이터 선언 - select : NoticeVO
		NoticeVO vo = null;
		
		// 보여줄 공지 글번호 선택 - 입력
		System.out.println("<< 공지 글보기의 번호 선택 >>");
		System.out.print("공지 번호 -> ");
		String data = scanner.nextLine(); // 공지 번호를 입력할 때 숫자로 존재하는 글번호를 잘 입력하셔야 합니다.
		long no = Long.parseLong(data);
			
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
			String sql = " SELECT no, title, content, TO_CHAR(startDate, 'yyyy.mm.dd') startDate, "
					+ " TO_CHAR(endDate, 'yyyy.mm.dd') endDate, "
					+ " TO_CHAR(updateDate, 'yyyy.mm.dd') updateDate FROM notice "
					+ " WHERE no = ? ";
			System.out.println("sql : " + sql);
			
			//4. 실행객체 & 데이터 셋팅
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, no);
			System.out.println("++--- 실행객체 생성 & 데이터 셋팅 완료");
			
			//5. 실행
			// select : pstmt.executeQuery() - 결과 : ResultSet
			// insert, update, delete : pstmt.executeUpdate() - 결과 : int
			rs = pstmt.executeQuery();
			System.out.println("++--- 실행 완료");
			
			//6. 출력 (NoticeCVO -> 출력) - 데이터가 한개
			// 1) 데이터를 NoticeVO에 담기
			if(rs != null && rs.next()) { // 결과 저장 객체가 null이 아니고 데이터가 있어야 한다.
				// rs -> vo로 데이터 담기.
				vo = new NoticeVO(); // 생성한 후 저장한다.
				// rs에서 꺼내서 vo에 담기
				vo.setNo(rs.getLong("no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setStartDate(rs.getString("startDate"));
				vo.setEndDate(rs.getString("endDate"));
				vo.setUpdateDate(rs.getString("updateDate"));
				// 데이터 확인
				System.out.println("DB에서 가져온 데이터 확인 : " + vo);
			} // end of if(rs != null && rs.next())
			
			// 2) vo에 있는 데이터 출력하기
			System.out.println("+--------------------------------------------------------------+");
			// 데이터가 없는 경우의 처리 - vo가 null이 나온다.
			if(vo == null) // 데이터가 없다.
				System.out.println("+  데이터가 존재하지 않습니다.");
			else { // 데이터가 있다. -> 있는 데이터를 출력하자.
				System.out.println("+ 공지번호 : " + vo.getNo());
				System.out.println("+ 제목 : " + vo.getTitle());
				System.out.println("+ 내용 : " + vo.getContent());
				System.out.println("+ 공지 시작일 : " + vo.getStartDate());
				System.out.println("+ 공지 종료일 : " + vo.getEndDate());
				System.out.println("+ 최종 수정일 : " + vo.getUpdateDate());
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
