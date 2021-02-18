/*
 * 삭제할 글번호를 받아서 삭제를 진행한다.
 */
package ch16JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BoardDeleteDAO {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 필요한 객체 ~ 정보
		// DB delete처리를 한다.
		// 필요한 객체 선언 - delete - con, pstmt
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// DB 정보
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "java00";
		String pw = "java00";
		
		// 리턴되는 데이터 선언 : delete - int
		int result = 0;

		
		try {
			// 삭제할 글번호 받기
			System.out.print("삭제할 글번호를 입력하시오 -> ");
			String data = scanner.nextLine();
			long no = Long.parseLong(data);
			
			// DB 처리 - delete : insert, update, delete - 같은 부류의 프로그램- 사용객체 2개, 리턴타입이 int
			// 1. 드라이버 확인
			Class.forName(driver); // 클래스 확인을 하고 static으로 선언된 부분이 로딩된다.
			System.out.println("드라이버 확인 완료.");
			// 2. 연결
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("연결 객체 생성 완료");
			// 3. 쿼리 작성
			// ? : 값으로 대체되는 대체문자.
			String sql = "delete from board where no = ?";
			System.out.println("sql:" + sql);
			// 4. 실행객체 & 데이터 셋팅
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, no);
			System.out.println("실행 객체와 데이터 셋팅 완료");
			// 5. 실행
			result = pstmt.executeUpdate();
			System.out.println("실행 완료");
			// 6. 출력
			if(result > 0) System.out.println("게시판 글번호 "+ no +"을 삭제하였습니다.");
			System.out.println("출력 완료");
		
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
