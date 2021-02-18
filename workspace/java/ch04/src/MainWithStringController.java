import java.util.Scanner;

public class MainWithStringController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		//1.인사
		System.out.println("방가방가");
		//무한반복 ------ 시작
		while(true) {
			//메뉴 출력
			System.out.println("1.공지사항 2.게시판 3.로그인 0.프로그램 종료");
			//메뉴 선택
			System.out.println("메뉴를 선택하세요.");
			String menu = scanner.nextLine();
			//메뉴 처리
			//if () else if 로 코딩 처리
			/*
			if(menu.equals("1"))
				System.out.println("공지사항 처리함. 뻥~~~");
			else if(menu.equals("2"))
				System.out.println("게시판 처리함. 뻥~~~");
			else if(menu.equals("3"))
				System.out.println("로그인 처리함. 뻥~~~");
			else if(menu.equals("0")) {
				System.out.println("바이바이");
				scanner.close();
				System.exit(0); //개발자에 의한 정상종료 -> 0						
			} else
				System.out.println("잘못된 메뉴를 선택했습니다.");	
				*/
			
			
			
			//switch case로 코딩 
			switch(menu) {
			case "1": //menu가 문자열이기 때문에 ""써야함
				System.out.println("공지사항 처리함. 뻥~~");
				break;
			case "2": //menu가 문자열이기 때문에""
				System.out.println("게시판 처리함. 뻥~~");
				break;
			case "3": //menu가 문자열이기 때문에""
				System.out.println("로그인 처리함. 뻥~~");
				break;
			case "0": //menu가 문자열이기 때문에""
				System.out.println("바이바이");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("잘못된 메뉴를 입력하셨습니다.");
			}//end of switch
		}
		//무한반복------끝
}
}
