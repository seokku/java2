/** 별도의 도규멘트 작성 가능 - 마우스를 올리면 보여지는 곳이 된다.
 * BoardViewDAO : 게시판의 글보기 작성 - select
 */
package ch16JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardViewDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 필요한 객체 선언
		// 연결 객체
		Connection con = null;
		// 실행 객체
		PreparedStatement pstmt = null;
		// 결과 저장 객체
		ResultSet rs = null;
		
		// DB 서버에 연결할 때 사용되는 정보
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "java00";
		String pw = "java00";
		
		// 보여 줄 데이터 - 원래는 파라메터로 받는다. - 사용자는 키보드로 입력을 받는다.
		long no = 1282;
		
		// 리턴 저장 객체 선언
		BoardVO vo = null;
		
		// 프로그램 패턴
		try { // 정상
			// 1. 확인
			Class.forName(driver);
			// 2. 연결
			con = DriverManager.getConnection(url, id, pw);
			
			/* ** 글보기를 하기 위한 데이터를 가져 오기 전에 조회수를 1증가 시키는 처리를 한다. ** */
			// 3. 쿼리작성
			// ? : 값을 대체해야 하는 부분에 대체문자
			String sql = "update board set hit = hit + 1 where no = ?";
			// 4. 실행 객체 & 데이터 셋팅
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, no);
			// 5. 실행
			//  select - pstmt.executeQuery() - 결과가 ResultSet
			//  insert, update, delete - pstmt.executeUpdate() - 결과가 int
			int result = pstmt.executeUpdate();
			// 6. 출력
			if(result != 0) System.out.println("조회수가 1 증가됨.");
			else {
				System.out.println("조회수가 1증가 되지 않음. - 글번호가 존재하지 않음.");
				throw new Exception("조회수 1증가 안됨. - 글번호가 존재하지 않음.");
			}
			// 7. 닫기(pstmt)
			pstmt.close();
			/* 조회수 1 증가의 끝 */
			
			// 3. 쿼리 작성
			// ? : 값을 대체해야 하는 부분에 대체문자
			sql = "select no, title, content, writer, writeDate, hit "
					+    " from board "
					+    " where no = ?";
			// 4. 실행 객체 & 데이터 셋팅
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, no);
			// 5. 실행
			//  select - pstmt.executeQuery() - 결과가 ResultSet
			//  insert, update, delete - pstmt.executeUpdate() - 결과가 int
			rs = pstmt.executeQuery();
			// 6. 출력 -- 데이터가 한개가 나오거나 또는 나오지 않는다.
			if(rs != null && rs.next()) { // 데이터를 가져온 경우
				vo = new BoardVO(); // 저장할 vo 객체 생성
				vo.setNo(rs.getLong("no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWriteDate(rs.getString("writeDate"));
				vo.setHit(rs.getLong("hit"));
			}
			
			System.out.println("+-------------------------------------+");
			System.out.println(" 번호:" + vo.getNo());
			System.out.println(" 제목:" + vo.getTitle());
			System.out.println(" 내용:" + vo.getContent());
			System.out.println(" 작성자:" + vo.getWriter());
			System.out.println(" 작성일:" + vo.getWriteDate());
			System.out.println(" 조회수:" + vo.getHit());
			System.out.println("+-------------------------------------+");
			
		} catch(Exception e) { // 예외처리
			e.printStackTrace();
		} finally { // 받으시 처리
			try {// 정상처리
				// 7. 닫기
				if(con != null) con.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e) { // 예외처리
				e.printStackTrace();
			}
		}
		
	}

}
