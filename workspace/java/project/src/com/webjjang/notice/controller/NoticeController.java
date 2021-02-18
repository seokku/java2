//공지사항 메뉴
package com.webjjang.notice.controller;

import java.util.Scanner;

import com.webjjang.main.controller.Controller;

public class NoticeController implements Controller {
	
	//입력하는 객체 생성
	//변수 = 전역변수 = 인스턴스변수(static이 없음)  = 멤버변수 = 필드 = 속성
	Scanner scanner = new Scanner(System.in);
	
	//모든 컨트롤러에 적용되는 통일된 메서드 형식 - 약속
	@Override // 재정의해서 사용하는 건지 확인해주는 오버라이드 어노테이션
	public void execute() {
		//System.out.println("NoticeController.excute() 공지사항 메뉴 실행 중");
		//게시판의 처리 무한 반복 - 시작
		while(true) {
			//위치 정보 출력
			System.out.println("----------------------------------------------------------------------");
			System.out.println("현재 위치는 main > notice");
			System.out.println("----------------------------------------------------------------------");
			
			//메뉴출력
			System.out.println("----------------------------------------------------------------------");
			System.out.println("1.리스트 2.글보기 3.글쓰기 4.글수정 5.글삭제 0.이전메뉴");
			System.out.println("----------------------------------------------------------------------");
			
			//메뉴 입력 메시지 출력
			System.out.print("메뉴를 선택하세요 : ");
			
			//메뉴입력
			String menu = scanner.nextLine();
			
			//메뉴처리
			switch(menu) {
			case "1":
				System.out.println("공지사항 리스트 처리");
				break;
			case "2":
				System.out.println("공지사항 글보기 처리");
				break;
			case "3":
				System.out.println("공지사항 글쓰기 처리");
				break;
			case "4":
				System.out.println("공지사항 글수정 처리");
				break;
			case "5":
				System.out.println("공지사항 글삭제 처리");
				break;
			case "0":
				return; //메서드를 빠져나가 호출한 곳(MainController)으로 간다.
				//break; //switch, 반복문을 빠져나간다.
			default:
				System.out.println("잘못된 메뉴를 선택하셨습니다.");
				break;
			}
		}
		//게시판의 처리 무한 반복 - 끝

	}
		
}
