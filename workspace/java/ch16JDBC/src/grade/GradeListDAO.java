/*
 * 등급 리스트
 */
package grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GradeListDAO {

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
		List<GradeVO> list = null;
		
		// 선택되어진 데이터 가져오기
		try { // 정상처리 : 1~6
			//1. 확인
			Class.forName(driver);
			System.out.println("++--- 드라이버 확인 완료");
			//2. 연결
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("++--- 연결 완료");
			//3. 쿼리 작성
			String sql = " SELECT gradeNo, gradeName FROM grade ORDER BY gradeNo ";
			
			//4. 실행객체 & 데이터 셋팅
			pstmt = con.prepareStatement(sql);
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
					if(list == null) list = new ArrayList<>();
					GradeVO vo = new GradeVO(); // 생성한 후 저장한다.
					// rs에서 꺼내서 vo에 담기
					vo.setGradeNo(rs.getInt("gradeNo"));
					vo.setGradeName(rs.getString("gradeName"));
					// vo -> list
					list.add(vo);
				} // end of while(rs.next())
				// 데이터 확인
				System.out.println("DB에서 가져온 데이터 확인 : " + list);
			} // end of if(rs != null)
			
			// 2) list에 있는 데이터 출력하기
			System.out.println("+-----------------------+");
			System.out.println("+   등급 번호  /     등급명    +");
			System.out.println("+-----------------------+");
			// 데이터가 없는 경우의 처리 - list가 null이 나온다.
			if(list == null) // 데이터가 없다.
				System.out.println("+  데이터가 존재하지 않습니다.");
			else { // 데이터가 있다. -> 있는 데이터를 출력하자.
				// 데이터가 있는 만큼 향상된 for
				for(GradeVO vo : list) {
					System.out.print("+ " + vo.getGradeNo());
					System.out.print(" / " + vo.getGradeName());
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
