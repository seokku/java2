package ch10exception;

import java.util.Scanner;

public class DivisionByZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String data = null; //선언만 했고 주소가 없는 것으로 초기화
		
		//데이터 처리가 정상적으로 끝날 때까지 무한 반복
		while(true) {
		//정상적인 처리가 되도록 예외 처리		
			try{
				//정상처리
				//2개의 숫자를 입력하세요
				System.out.println("첫번째 숫자를 입력하세요.");
				data = scanner.nextLine();
				int a = Integer.parseInt(data);
				System.out.println("두번째 숫자를 입력하세요.");
				data = scanner.nextLine();
				int b = Integer.parseInt(data);
				//앞의 숫자를 뒤에 숫자로 나눈 결과 출력
				System.out.println("첫번째 숫자" + a + "/" + "두번째 숫자" + b + "=" +(a/b));
				break;
			}catch(ArithmeticException e) {
				//예외처리
				//개발자를 위한 에러 출력 - 개발이 완료되면 주석처리
				//e.printStackTrace();
				//사용자를 위한 에러 출력
				System.out.println("두 번째 숫자는 0을 입력하시면 안됩니다.");
			}finally {
				System.out.println("데이터처리(반드시 실행):try~catch~finally");
			}
			
		}//end of while
		scanner.close();
		System.out.println("프로그램 종료");
	}

}
