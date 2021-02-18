import java.util.Scanner;

public class ThreeItemOp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//숫자를 입력받는다.
		System.out.println("점수를 입력하세요 : ");
		String data = scanner.nextLine();
		int score = Integer.parseInt(data);
		//60점 이상이면 합격, 미만이면 불합격 출력
		//기본 if(조건) ~; else 처리문; 을 사용
		if(score >= 60)
			System.out.println("합격");
		else
			System.out.println("불합격");
		
		//삼항연산자 = 조건 연산자 -> 결과가 나와야 한다.
		//(조건)?true의 처리:false의 처리
		//(score >= 60)? System.out.println("합격"):System.out.println("불합격");
		System.out.println((score >= 60)?"합격":"불합격");
		String result = (score >= 60)?"합격":"불합격";
		System.out.println(result);
		scanner.close();	}//end of main

}
