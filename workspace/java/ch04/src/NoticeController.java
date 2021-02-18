import java.util.Scanner;

public class NoticeController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//입력 객체 불러온다. - 객체 생성 - new
		Scanner scanner = new Scanner(System.in);
		
		//1.환영 인사 - 공지사항에 들어오심.
		System.out.println("공지사항에 들어오셨습니다.");
		
		//무한반복 - while
		while(true) {
			//2.위치 출력 -"/공지사항
			System.out.println("\\공지사항");
			//3.메뉴출력
				//1.리스트 2.글쓰기 3.글보기
				//4.글수정 5.글삭제 0.종료 - 강제 정상 종료
			System.out.println("1.리스트 2.글쓰기 3.글보기");
			System.out.println("4.글수정 5.글삭제 0.종료");
			//4.메뉴입력메시지
			System.out.println("메뉴 입력 --> ");
			//5.메뉴입력
			String data = scanner.nextLine();
			//6.입력한 메뉴 처리 뻥치기 - switch()
			int menu = Integer.parseInt(data);
			switch(menu) {
			case 1:
				System.out.println("공지사항 리스트 처리함....뻥");
				break;
			case 2:
				System.out.println("공지사항 글쓰기 처리함....뻥");
				break;
			case 3:
				System.out.println("공지사항 글보기 처리함....뻥");
				break;
			case 4:
				System.out.println("공지사항 글수정 처리함....뻥");
				break;
			case 5:
				System.out.println("공지사항 리스트 처리함....뻥");
				break;
			case 6:
				System.out.println("공지사항 글삭제 처리함....뻥");
				break;
			case 0:
				System.out.println("프로그램 종료");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("메뉴를 잘못 선택");
			}//end of switch
		}
	}

}
