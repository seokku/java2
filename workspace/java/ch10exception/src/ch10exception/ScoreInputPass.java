package ch10exception;

import java.util.Scanner;

public class ScoreInputPass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//점수 입력
		int score = 0;
		//숫자가 아니면 무한반복한다. -예외가 발생했다 -> catch로 간다.
		while(true) {
		//입력한 데이터가 숫자가 아니면 "숫자가 아닙니다." 출력 -> 프로그램 종료
			try {
				//정상처리 시도
				System.out.println("점수를 입력하세요");
				String data = scanner.nextLine();
				score = Integer.parseInt(data);
				break; // 정상적인 데이터가 들어오면 while문 빠져나옴
			}catch(NumberFormatException e) { 
				//예외처리 - NumberFormatException
				//개발자를 위한 메시지
				//e.printStackTrace();
				//사용자에게 보여주는 메시지
				System.out.println("숫자를 입력하셔야만 합니다.");
			}finally {
				System.out.println("데이터 처리(반드시 실행):try~catch~finally");
			}//end of try~catch~finally
			
		}//end of while
		
		//60점 이상이면 합격 아니면 불합격
		if(score >= 60)
			System.out.println("합격");
		else
			System.out.println("불합격");
		
		System.out.println("프로그램 종료");
		scanner.close();
	}

}
