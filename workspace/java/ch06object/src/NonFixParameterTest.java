import java.util.Arrays;

public class NonFixParameterTest {
 
	//문제. 자바에서 처음 시작되는 main 메서드를 작성하시오.
	public static void main(String[] args) {
		System.out.println("NonFixParameterTest.main() 실행중");
		int kor = 100; //점수
		int eng = 80;
		int meth = 90;
				
		//위 과목의 점수합계를 구하세요.
		//합계 구하기
		//아래 배열을 받는 sum() 사용하기 위해서 배열로 만든다.
		//int sum = sum(new int[] {kor, eng, meth}); //new에서 생성해서 배열로 만들기
		
		//타입이 int인 여러 개의 데이터를 받는 메서드는 배열도 받는다.
		int sum = sum(kor, eng, meth);
		System.out.println("sum = " + sum);
		
	}
	
	//중복해지거나 복잡해지면 소스를 꺼낸다.
	//합계 구하는 메서드 만들기
	//타입이 배열인 데이터를 받는 sum 메서드
	/*public static int sum(int[] scores) { 
		System.out.println("NonFixParameterTest.sum().scores : " + Arrays.toString(scores)); //넘어온 데이터 확인
		int result = 0; //return타입과 똑같은 변수 선언
		for(int i=0; i < scores.length; i++)
			result += scores[i];
		return result;
	}
	 */
	//타입이 int 여러개의 데이터를 받는 sum 메서드 -> 이 때 scores는 배열이다. ...은 마지막 매개변수에서만 사용이 가능하다.
	public static int sum(int ... scores) { //위의 데이터가 넘어올 때 자동으로 배열을 만든다. 
		System.out.println("NonFixParameterTest.sum().scores : " + Arrays.toString(scores)); //넘어온 데이터 확인
		int result = 0; //return타입과 똑같은 변수 선언
		for(int i=0; i < scores.length; i++)
			result += scores[i];
		return result;
	}
	
}
