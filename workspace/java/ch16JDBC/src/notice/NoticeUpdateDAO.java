package notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class NoticeUpdateDAO {

	// 입력 받는 객체 생성
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// 필요한 객체 선언
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// DB 접속 정보
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "java00";
		String pw = "java00";
		
		// 수정을 위한 데이터 가져오기 객체 선언 : NoticeVO
		NoticeVO vo = null;
		
		// 수정 결과를 저장하는 변수
		int result = 0;
		
		try {
			
			// 수정할 글번호 받기 - no
			System.out.print("수정할 글번호 입력 -> ");
			String data = scanner.nextLine();
			long no = Long.parseLong(data);
			System.out.println("수정할 글번호 : " + no);
			
			// 수정할 글번호에 해당되는 데이터 가져오기 - NoticeVO : 1~7 -> view : NoticeViewDAO try안 전체 ---------------------------------
			// 1. 확인 - DB 처리 시 한번만 하면 된다.
			Class.forName(driver);
			System.out.println("데이터 가져오기 - 드라이버 확인");
			// 2. 연결
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("데이터 가져오기 - 연결 완료");
			
			// 조회수 1증가 부분 삭제
			
			// 3. 쿼리 작성
			// ? : 값을 대체해야 하는 부분에 대체문자
			// 날짜를 날짜 패턴에 맞추지 않으면 오류가 나므로 날짜 패턴문을 이용하여 패턴을 만들어 가져와야 한다.
			String sql = "select no, title, content, to_char(startDate, 'yyyy-mm-dd') startDate, "
					+ " to_char(endDate, 'yyyy-mm-dd') endDate "
					+    " from notice "
					+    " where no = ?";
			System.out.println("데이터 가져오기 - 쿼리 작성 : " + sql);
			// 4. 실행 객체 & 데이터 셋팅
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, no);
			System.out.println("데이터 가져오기 - 실행 객체 생성 & 데이터 셋팅");
			// 5. 실행
			//  select - pstmt.executeQuery() - 결과가 ResultSet
			//  insert, update, delete - pstmt.executeUpdate() - 결과가 int
			rs = pstmt.executeQuery();
			System.out.println("데이터 가져오기 - 실행 완료");
			// 6. 출력 -- 데이터가 한개가 나오거나 또는 나오지 않는다.
			if(rs != null && rs.next()) { // 데이터를 가져온 경우
				vo = new NoticeVO(); // 저장할 vo 객체 생성
				vo.setNo(rs.getLong("no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setStartDate(rs.getString("startDate"));
				vo.setEndDate(rs.getString("endDate"));
			}
			
			System.out.println("+-------------------------------------+");
			System.out.println(" 번호:" + vo.getNo());
			System.out.println(" 제목:" + vo.getTitle());
			System.out.println(" 내용:" + vo.getContent());
			System.out.println(" 공지 시작일:" + vo.getStartDate());
			System.out.println(" 공지 종료일:" + vo.getEndDate());
			System.out.println("+-------------------------------------+");
			System.out.println("데이터 가져오기 - 가져온 데이터 출력 완료");
			// 7. 닫기.
			if(con != null) con.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			// 수정할 데이터 받아오기 끝 ------------------------------------------------------------------------------------

			
			// 가져온 데이터를 수정하기 - vo.setter() -> NoticeWriteDAO -> 데이터확인 : 수정 무한 루프(while(true))
			while(true) {
				// 데이터 확인
				System.out.println(vo);
				// 수정할 항목 선택
				// 메뉴 출력
				System.out.println("1. 제목  2. 내용  3. 공지 시작일  4. 공지 종료일  0. 수정완료");
				System.out.print("수정할 항목을 입력하세요. -> ");
				// 메뉴 선택
				String menu = scanner.nextLine();
				// 메뉴 처리
				if(menu.equals("1")) {
					System.out.print("제목 -> ");
					vo.setTitle(scanner.nextLine());
				} else if(menu.equals("2")) {
					System.out.print("내용 -> ");
					vo.setContent(scanner.nextLine());
				} else if(menu.equals("3")) {
					System.out.print("공지 시작일(YYYY-MM-DD) -> ");
					vo.setStartDate(scanner.nextLine());
				} else if(menu.equals("4")) {
					System.out.print("공지 종료일(YYYY-MM-DD) -> ");
					vo.setEndDate(scanner.nextLine());
				} else if(menu.equals("0")) {
					break; // while 문을 빠져 나가서 DB에 글수정 적용을 하러간다.
				} else {
					System.out.println("항목을 잘못 선택하셨습내니다. 1~4,0번을 입력하셔야 합니다.");
				} // end of if()else if() else
				
			} // end of while(true) - 데이터 수정 입력
			
			System.out.println("데이터 수정 입력 완료(DB 수정 전) - vo : " + vo);
			
			// 수정한 데이터 DB에 적용하기 - insert - 1~7 : insert, update, delete 
			//  -> 비슷한 류의 프로그램 -> try 안에 소스 복붙 후 약간의 수정 : NoticeWriteDAO
			// 1. 드라이버 확인 - 위에 했다.
			// Class.forName(driver); // 클래스 확인을 하고 static으로 선언된 부분이 로딩된다.
			// System.out.println("드라이버 확인 완료.");
			// 2. 연결
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("DB 수정 - 연결 객체 생성 완료");
			// 3. 쿼리 작성 - 위의 sql 변수를 재활용
			sql = "update notice set title = ?, content = ?, startDate = ?, endDate = ? where no = ?";
			System.out.println("DB 수정 - sql:" + sql);
			// 4. 실행객체 & 데이터 셋팅
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate());
			pstmt.setLong(5, vo.getNo());
			System.out.println("DB 수정 - 실행 객체와 데이터 셋팅 완료");
			// 5. 실행
			result = pstmt.executeUpdate();
			System.out.println("DB 수정 - 실행 완료");
			// 6. 출력
			if(result > 0) System.out.println("공지사항의 글 "+ vo.getNo() +"번이 수정되었습니다.");
			System.out.println("DB 수정 - 수정 완료");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 7. 닫기
				if(con != null) con.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		} // end of try{} catch(){} finally{}
		
	} // end of main()
	
}
