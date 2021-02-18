package ch10exception;

import java.util.Scanner;

public class ThrowsTest2 {
	
	static Scanner scanner = new Scanner(System.in);
	
	static int a, b; //전역변수로 지정, 모든 메서드에 사용 가능
	
	public static void main(String[] args) {
		
		try {
			//정상처리
			//1.데이터를 받는다.
			inData(); //a, b 데이터가 셋팅됨
			
			//2.나누기 연산을 한다.
			int result = divOp(); //divOp()로 가서 계산한 후 결과가 리턴됨
		
			//3.결과를 출력한다.
			print(result);
			/*}catch(NumberFormatException e) {
				//예외처리
				System.out.println("숫자만 입력하세요.");
			}catch(ArithmeticException e) {
				//예외처리
				System.out.println("두번째 숫자는 0이 아니어야만 합니다. 모든 숫자는 0으로 나눌 수 없습니다.");
				*/
			}catch(Exception e) {
				System.out.println("나누기 연산 수행 중 오류가 발생되었습니다.");
			}
		
		System.out.println("프로그램을 종료합니다.");
	}
	
	//데이터를 입력받는 메서드(출력하니까 void)
	static void inData() throws NumberFormatException {
		//첫번째 데이터 받기
		System.out.println("첫번째 숫자를 입력하세요.");
		String data = scanner.nextLine();
		a = Integer.parseInt(data);
		
		//두번째 데이터 받기
		System.out.println("두번째 숫자를 입력하세요.");
		data = scanner.nextLine();
		b = Integer.parseInt(data);
		}
	
	
	//나누기를 연산하는 메서드
	static int divOp() throws ArithmeticException{
			return a / b;	
	}
	
	//결과를 출력하는 메서드
	static void print(int result) throws Exception{
		System.out.println(a + " / " + b + " = " + result);
	}
	
}
