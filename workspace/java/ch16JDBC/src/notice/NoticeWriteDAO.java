package notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class NoticeWriteDAO {

	// 데이터를 입력받는 객체
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 데이터를 받는다. - 제목, 내용, 공지시작일, 공지 종료일
		System.out.print("제목 입력 -> ");
		String title = scanner.nextLine();
		System.out.print("내용 입력 -> ");
		String content = scanner.nextLine();
		System.out.print("공지시작일(YYYY-MM-DD) 입력 -> ");
		String startDate = scanner.nextLine();
		System.out.print("공지종료일(YYYY-MM-DD) 입력 -> ");
		String endDate = scanner.nextLine();
		
		// NotcieVO 생성한 후 데이터 저장
		NoticeVO vo = new NoticeVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setStartDate(startDate);
		vo.setEndDate(endDate);
		
		System.out.println("NoticeVO : " + vo);
		
		// DB insert처리를 한다.
		// 필요한 객체 선언 - insert - con, pstmt
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// DB 정보
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "java00";
		String pw = "java00";
		
		// 리턴되는 데이터 선언 : insert - int
		int result = 0;

		// jdbc 패턴
		try {
			// 1. 드라이버 확인
			Class.forName(driver); // 클래스 확인을 하고 static으로 선언된 부분이 로딩된다.
			System.out.println("드라이버 확인 완료.");
			// 2. 연결
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("연결 객체 생성 완료");
			// 3. 쿼리 작성
			String sql = "insert into notice(no, title, content, startDate, endDate) values(notice_seq.nextval, ?, ?, ?, ?)";
			System.out.println("sql:" + sql);
			// 4. 실행객체 & 데이터 셋팅
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate());
			System.out.println("실행 객체와 데이터 셋팅 완료");
			// 5. 실행
			result = pstmt.executeUpdate();
			System.out.println("실행 완료");
			// 6. 출력
			if(result > 0) System.out.println("공지사항에 새로운 공지가 등록되었습니다.");
			System.out.println("등록 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 7. 닫기
				if(con != null) con.close();
				if(pstmt != null) pstmt.close();
				System.out.println("닫기 완료");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
// 등록이 완료가 되면 공지리스트에서 꼭 확인을 한다.
