/*부모 클래스
 * 공통 - 보기 + 조회수 증가, 수정, 삭제 : 여기서 구현
 * 별도 코딩 - 리스트, 쓰기 : 메서드는 통일을 시키고 구현은 자식 클래스에서 하도록 한다.
 */

package ch07Inheritace;

//추상 메서드를 가지고 있는 클래스 = 추상클래스
public abstract class BoardDAO {
	
	//1.리스트 - 여기서 구현하지 않고 자식 클래스에서 별도 코딩하도록 한다.
	public abstract void list(); // 구현하지 않으므로 {} 생략하고 추상메서드로 만들기
	
	//2.글보기
	  //조회수 1증가
	public void increase() {
		System.out.println("BoardDAO.increas()실행 중 - 조회수 1증가");
	}
	  //글보기 데이터
	public void view() {
		System.out.println("BoardDAO.view()실행 중 - 글보기 데이터 가져오기 - select");
	}
	
	//3.글쓰기 - 여기서 구현하지 않고 자식 클래스에서 별도 코딩하도록 한다.
	public abstract void write();
	
	//4.글수정
	public void update() {
		System.out.println("BoardDAO.update()실행 중 - 글수정");
	}
	
	//5.글삭제
	public void delete() {
		System.out.println("BoardDAO.delete()실행 중 - 글삭제");
	}
}
