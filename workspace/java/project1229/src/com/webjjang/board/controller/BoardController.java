package com.webjjang.board.controller;

import java.util.Scanner;

import com.webjjang.main.controller.Controller;


public class BoardController implements Controller{

	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void execute() {
		//System.out.println(getClass().getSimpleName());
		
		while(true) {
			try {
				System.out.println("----------------------------------------------------------------------");
				System.out.println("현재 위치는 board 입니다.");
				System.out.println("----------------------------------------------------------------------");
				
				System.out.println("----------------------------------------------------------------------");
				System.out.println("1.리스트 2.글보기  3.글쓰기 4.글수정 5.글삭제 0.이전메뉴");
				System.out.println("----------------------------------------------------------------------");
				
				System.out.println("메뉴를 선택하세요 : ");
				
				
				String menu = scanner.nextLine();
				
				switch(menu) {
				case "1":
					System.out.println("게시판 리스트 처리");
					break;
				case "2":
					System.out.println("게시판 글보기 처리");
					break;
				case "3":
					System.out.println("게시판 글쓰기 처리");
					break;
				case "4":
					System.out.println("게시판 글수정 처리");
					break;
				case "5":
					System.out.println("게시판 글삭제 처리");
					break;
				case "0":
					return;
				default:
					System.out.println("잘못된 메뉴를 선택했습니다.");
					}
				}catch(Exception e) {
					System.out.println("게시판 작업 중 오류가 발생했습니다.");
			}
			
	}
	
}
}
