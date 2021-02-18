package com.webjjang.qna.controller;

import java.util.Scanner;

import com.webjjang.main.controller.Controller;

public class QnaController implements Controller{

	//데이터를 입력받는 Scanner 선언과 초기값 셋팅
	Scanner scanner = new Scanner(System.in);
	
	
	//인터페이스에서 상속받은 메서드를 재정의해서 사용해야만 한다.
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		while(true) {
			try {
				//정상처리
				//위치 출력
				System.out.println("-------------------------------------------------");
				System.out.println("*현재 위치 : main > qna.*");
				System.out.println("-------------------------------------------------");
				//메뉴출력
				System.out.println("-------------------------------------------------");
				System.out.println("1.리스트 2.글보기 3.질문하기 4.답변하기 5.글수정 6.글삭제 0.이전메뉴");
				System.out.println("-------------------------------------------------");
				
				//메뉴입력 메시지 출력
				System.out.print("메뉴를 선택하세요 : ");
				
				//메뉴입력
				String menu = scanner.nextLine();
				
				//메뉴처리
				switch(menu) {		
				case "1":
					//1.리스트 - 1) DB에서 데이터 가져오기 2) 데이터 출력 {1번에서 예외가 발생하면 catch문으로 이동하여 2번은 실행이 안 되도록 처리}
					System.out.println("<<질문답변 리스트 처리>>");
					break;
				case "2":
					//2.글보기 - 1) DB에서 데이터 가져오기 2) 데이터 출력 {1번에서 예외가 발생하면 catch문으로 이동하여 2번은 실행이 안 되도록 처리}
						System.out.println("<<질문답변 글보기 처리>>");
						break;
				case "3":
					//3.질문하기 - 1) DB에서 데이터 가져오기 2) DB에 저장 {1번에서 예외가 발생하면 catch문으로 이동하여 2번은 실행이 안 되도록 처리}
						System.out.println("<<질문답변 질문하기 처리>>");
						break;
				case "4":
					//4.답변하기 - 1) DB에서 데이터 가져오기 2) 데이터 출력 3)수정 4)DB에 수정적용
						System.out.println("<<질문답변 답변하기 처리>>");
						break;
				case "5":
					//5.수정 - 1) DB에서 데이터 가져오기 2) DB에 적용
						System.out.println("<<질문답변 글수정 처리>>");
						break;
				case "6":
					//삭제 - 1) DB에서 데이터 가져오기 2) DB에 적용
					System.out.println("<<질문답변 글삭제 처리>>");
					break;
				case "0":
					//호출한 곳으로 돌아간다.
					return;
				default:
					System.out.println("<<잘못된 메뉴를 선택하셨습니다.>>");
				
				}
				
			}catch(Exception e) {
				//예외처리
				//개발자를 위한 코드
				e.printStackTrace();
				//사용자를 위한 코드
				System.out.println("<<게시판 처리 중 오류가 발생했습니다.>>");
			}
		}
		
		
	}

}
