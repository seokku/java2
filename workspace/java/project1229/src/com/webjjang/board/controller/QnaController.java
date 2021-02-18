package com.webjjang.board.controller;

import java.util.Scanner;

import com.webjjang.main.controller.Controller;

public class QnaController implements Controller{

	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		while(true) {
			try {
			System.out.println("----------------------------------------------------------------------");
			System.out.println("현재 위치는 Qna 입니다.");
			System.out.println("----------------------------------------------------------------------");
			
			System.out.println("----------------------------------------------------------------------");
			System.out.println("1.리스트 2.글보기  3.질문하기 4.답변하기 5.글삭제 0.이전메뉴");
			System.out.println("----------------------------------------------------------------------");
			
			System.out.println("메뉴를 선택하세요 : ");
			
			String menu = scanner.nextLine();
			switch(menu) {
			
			case "1":
				System.out.println("질문답변 리스트 처리");
				break;
			case "2":
				System.out.println("질문답변 글보기 처리");
				break;
			case "3":
				System.out.println("질문답변 질문하기 처리");
				break;
			case "4":
				System.out.println("질문답변 답변하기 처리");
				break;
			case "5":
				System.out.println("질문답변 글삭제 처리");
				break;
			case "0":
				return;
			default:
				System.out.println("잘못된 메뉴를 선택했습니다.");
				}
			} catch(Exception e) {
				System.out.println("질문답편 작업 중 오류가 발생되었습니다.");
			}
		}
		
	
	}
	
	
}

