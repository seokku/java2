package com.webjjang.main.controller;

import java.util.Scanner;

import com.webjjang.bord.controller.BoardController;
import com.webjjang.memo.controller.MemoController;
import com.webjjang.notice.controller.NoticeController;

//[MainController] -> Controller -> Service -> DAO 의 구조로 실행
public class MainController {

	//데이터를 입력하는 객체
	//객체를 저장해놓은 변수 = 객체 변수 = 전역 변수 = 멤버 변수 = 필드
	static Scanner scanner = new Scanner(System.in);
	
	//접근제한자 - public(공공), protected(다른 패키지에서는 new금지, 상속가능), default(같은 패키지에서만 사용과 상속가능), private(같은 클래스에서만 가능)
	//static:고정 클래스를 사용하게 되면 static이 먼저 메모리에 올라가게 된다.
	//void:리턴타입 중 하나, 메서드에서만 사용(값이 없다.)
	//main():처리문을 가지고 있는 메서드
	//String[]:문자열 배열타입의 변수 선언 - 매개변수
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//프로그램 시작 메시지 출력
		System.out.println("*환영합니다. 웹짱(주)입니다. 좋은 시간되세요.*");
		
		//무한반복 시작
		while(true) {
			//위치 출력
			System.out.println("----------------------------------------------------------------------");
			System.out.println("현재 위치는 main");
			System.out.println("----------------------------------------------------------------------");
			
			//메뉴 출력
			System.out.println("----------------------------------------------------------------------");
			System.out.println("1.게시판 2.공지사항 3.메모장 0.종료");
			System.out.println("----------------------------------------------------------------------");
			
			//메뉴입력 메시지 출력
			System.out.print("메뉴를 선택하세요 : ");
			
			//메뉴 입력 - 문자열, 웹상에서 서버로부터 데이터를 받으면 모두 다 문자열이 된다.
			String menu = scanner.nextLine(); //데이터를 입력 받아서 처리한다.
			
			//메뉴 처리
			switch(menu) {
			case "1": //받은 데이터가 문자열이므로 ""로 표시
				System.out.println("게시판 처리");
				//게시판 컨트롤러 객체 생성하고 호출
				//BoardController boardController = new BoardController();
				//boardController.execute();
				
				//Controller 인터페이스 객체를 전달받아서 컨트롤러를 실행해주는 메서드(execute 메서드)에서 실행을 하도록 한다.
				execute(new BoardController());
				break;
			case "2":
				System.out.println("공지사항 처리");
				//공지사항 컨트롤러 객체 생성하고 호출
				//NoticeController noticeController = new NoticeController();
				//noticeController.execute();
				
				//Controller 인터페이스 객체를 전달받아서 컨트롤러를 실행해주는 메서드(execute 메서드)에서 실행을 하도록 한다.
				execute(new NoticeController());
				break;
			case "3":
				System.out.println("메모장 처리");
				//메모 컨트롤러 객체 생성하고 호출
				//MemoController memoController = new MemoController();
				//memoController.execute();
				
				//Controller 인터페이스 객체를 전달받아서 컨트롤러를 실행해주는 메서드(execute 메서드)에서 실행을 하도록 한다.
				execute(new MemoController());
				break;
			case "0":
				System.out.println("*프로그램을 종료합니다. 행복한 하루 되세요*");
				//0 : 프로그래머가 계획적으로 종료를 시켰다라고 하는 의미를 담고 있는 숫자(강제정상종료)
				System.exit(0);
			default:
				System.out.println("잘못된 메뉴를 선택하셨습니다.");
			}
		}
		
		//무한반복 끝
	}//end of main()
	
	//컨트롤러를 실행하는 메서드
	private static void execute(Controller controller) {
		System.out.println("MainController.execute(controller) 실행 중");
		
		//실행하려는(전달받은 controller) 클래스의 이름.execute() -> 출력
		System.out.println(controller.getClass().getSimpleName() + ".execute() 실행하려 함");
		
		//실행하려는 객체의 메서드 호출해서 실행
		controller.execute();
	}

}
