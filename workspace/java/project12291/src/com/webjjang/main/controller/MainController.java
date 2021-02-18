package com.webjjang.main.controller;

import java.util.Scanner;

import com.webjjang.board.controller.BoardController;
import com.webjjang.qna.controller.QnaController;

public class MainController {

	//main메서드에서 사용하는 Scanner이므로 static
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//환영인사
		System.out.println("=================================================");
		System.out.println("*환영합니다.*");
		System.out.println("=================================================");

		//메인 메뉴의 무한루프
		while(true) {
			//위치출력
			System.out.println("-------------------------------------------------");
			System.out.println("*현재 위치 : main.*");
			System.out.println("-------------------------------------------------");
			
			//메뉴출력
			System.out.println("-------------------------------------------------");
			System.out.println("1.게시판 2.질문답변 0.종료");
			System.out.println("-------------------------------------------------");
			
			//메뉴입력 메시지 출력
			System.out.print("메뉴를 선택하세요 : ");
			
			//메뉴입력
			String menu = scanner.nextLine();
			
			//메뉴처리
			switch(menu) {
			case "1":
				System.out.println("<<게시판 처리>>");
				//생성한 BoardController의 주소를 아래의 실행 메서드(execute())로 전달해준다.
				execute(new BoardController()); //입력 후 ctrl+space 누르기
				break;
			case "2":
				System.out.println("<<질문답변 처리>>");
				execute(new QnaController());
				break;
			case "0":
				System.out.println("*프로그램을 종료합니다.*");
				System.exit(0);
				break;
			default:
				System.out.println("<<잘못된 메뉴를 선택하셨습니다.>>");
			} //end of switch()
			
		} //end of while()
	} //end of main()

	//Controller를 실행하는 메서드 작성 -> Controller 객체(주소)를 받아서 실행하는 메서드
	private static void execute(Controller controller) {
		//실행되는 위치 출력
		System.out.println("MainController.execte() 실행 중");
		//전달받은 객체의 클래스 이름과 실행하는 메서드 출력
		System.out.println(controller.getClass().getSimpleName() + "execute() 실행 예정");
		//전달받은 객체의 실행 - 메서드를 호출해서 실행
		controller.execute();
		
		
	}
	
}
