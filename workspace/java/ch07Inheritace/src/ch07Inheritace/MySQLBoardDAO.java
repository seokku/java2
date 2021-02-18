/*
/ * 오라클 DB에 맞는 프로그램 작성
 * list와 write만 작성하고 나머지는 상속받기.
 * 부모 클래스에서  list()와 write()는 추상으로 만들었기 때문에 반드시 재정의해서 구현을 해야 오류가 없어진다.
 */

package ch07Inheritace;

public class MySQLBoardDAO extends BoardDAO{

	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("MySQLBoardDAO.list() - MySQL로 게시판 리스트 작성");
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("MySQLBoardDAO.write() - MySQL로 게시판 글쓰기 작성");
	}
	
}
