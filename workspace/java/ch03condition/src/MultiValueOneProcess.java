import java.util.Scanner;

public class MultiValueOneProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//월의 데이터 받기
		System.out.println("월을 입력하세요");
		String data = scanner.nextLine();
		int month = Integer.parseInt(data);
		
		//3,4,5:봄, 6,7,8:여름, 9,10,11:가을, 그외:입력오류
		switch (month) {
		case 3:
		case 4:
		case 5:
			System.out.println("계절은 봄입니다.");
			break;
		case 6:
		case 7:
		case 8:
			System.out.println("계절은 여름입니다.");
			break;
		case 9:
		case 10:
		case 11:
			System.out.println("계절은 겨울입니다.");
			break;
		case 12:
		case 1:
		case 2:
			System.out.println("계절은 여름입니다.");
			break;
		default :
			System.out.println("잘못된 데이터를 입력하셨습니다.");
		}
		scanner.close();   
	}

}
