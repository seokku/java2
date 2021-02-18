package ch10exception;

import java.util.Scanner;

public class IntegerDataExcep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		//정상처리
		// 숫자 데이터를 하나 받아서 출력하는 프로그램 작성 - 예외처리				
		// 숫자 출력
		try {
			// 숫자 데이터 하나를 문자열로 입력받고 
			System.out.println("숫자를 입력하세요.");
			String data = scanner.nextLine();
			// 숫자로 변환한다.
			int a = Integer.parseInt(data);
			System.out.println(a);		
			// 숫자 데이터가 아닙니다. 출력한다.
		}catch(NumberFormatException e) {
			//예외처리
			//개발자를 위하나 예외 정보 출력
			e.printStackTrace();
			System.out.println("숫자 데이터가 아닙니다.");
		}
		
		
		scanner.close();
		
	}

}
