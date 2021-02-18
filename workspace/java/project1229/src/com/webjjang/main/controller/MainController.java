package com.webjjang.main.controller;

import java.util.Scanner;

import com.webjjang.board.controller.BoardController;
import com.webjjang.board.controller.QnaController;

public class MainController {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*환영합니다.*");
		
		while(true) {
			System.out.println("----------------------------------------------------------------------");
			System.out.println("현재 위치는 main 입니다.");
			System.out.println("----------------------------------------------------------------------");
			
			System.out.println("----------------------------------------------------------------------");
			System.out.println("1.게시판 2.질문답변 0.종료");
			System.out.println("----------------------------------------------------------------------");
			
			System.out.print("메뉴를 선택하세요 : ");
			
			String menu = scanner.nextLine();
			
			switch(menu) {
			case "1": 
				System.out.println("게시판 처리");
				execute(new BoardController());
				break;
			case "2":
				System.out.println("질문답변 처리");
				execute(new QnaController());
				break;
			case "0":
				System.out.println("*프로그램을 종료합니다.*");
				
				System.exit(0);
			default:
				System.out.println("잘못된 메뉴를 선택하셨습니다.");
			}
		}
		
	}
	
	private static void execute(Controller controller) {
		System.out.println("MainController.execute(controller) 실행 중");	
		
		System.out.println(controller.getClass().getSimpleName() + ".execute() 실행하려 함");
		
		controller.execute();
	}

}
