package ch07Inheritace;

public class BoardDAOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//추상클래스로 생성가능한가? => 구현 가능하나 list와 write 추상메서드들에 대한 구현을 직접 해야만 한다.
		BoardDAO dao1 = new BoardDAO() {
			
			@Override
			public void write() {
				// TODO Auto-generated method stub
				System.out.println("추상클래스의 추상메서드 write() 직접구현");
				
			}
			
			@Override
			public void list() {
				// TODO Auto-generated method stub
				System.out.println("추상클래스의 추상메서드 list() 직접구현");

			}
		};
		dao1.write();
		dao1.view();
		
		OracleBoardDAO odao = new OracleBoardDAO();
		odao.list(); //출력됨
		MySQLBoardDAO mdao = new MySQLBoardDAO();
		mdao.list(); //출력됨
		
		//오라클에서 처리되는 리스트
		execute(odao, 1); //출력됨
		//MySQL에서 처리되는 리스트
		execute(mdao, 1); //출력됨
		
	}
	
	public  static void execute(BoardDAO dao, int menu) { //부모클래스이므로 자동캐스팅
		switch(menu) {
		case 1:
			dao.list();
			break;
		case 2:
			dao.increase(); //조회수 증가
			dao.view();
			break;
		case 3:
			dao.write();
			break;
		case 4:
			dao.update();
			break;
		case 5:
			dao.delete();
			break;
		default:
			System.out.println("BoardDAOTest.execute() 실행 중 - 처리 선택 번호가 아닙니다.");
		}
	}

}
