
public class OverloadCalcu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//2개의 데이터를 더하는 메서드를 작성
		//add()
		
		//아래 메서드들을 사용하려면 객체를 생성해야한다.
		OverloadCalcu oc = new OverloadCalcu();
		//add(10, 20) - int 더하기결과는 int, add(2.3, 4.5)-double 더하기결과는 double,
		// add("자바", "짱") -문자열 이어 붙이기결과는 string
		//int 연산을 하는 add()
		System.out.println(oc.add(10,  20)); //괄호 안이 먼저 실행 -> 밑 메서드로 가서 출력하고 계산 -> println 실행
		System.out.println(oc.add(2.3,  4.5));
		System.out.println(oc.add("java",  "jjang"));
		System.out.println(oc.add(10,  20.0)); //10은 int, double에 다 포함되고 20.0은 double이므로 double로 출력(int < double)
		System.out.println(oc.add("" + 10,  "java"));//10을 문자열로 바꾸기. (""+숫자) 로 바꾸면 숫자가 문자열로 변환됨
		
		//원래는 정수 연산만 가능하도록 코딩을 하고 있다.
		//Overload를 사용하면 편하지만 어떤 경우는 생각지 않은 오류가 날 수 있다.
		//아래와 같은 경우 논리 오류로 서로 값이 틀리게 나온다.그래서 이런 경우는 Overload를 이용한 것보다 메서드 이름을 다르게 하는 것은 지향한다.
		//int 연산인 경우는 addInt(), double 연산인 경우는 addDouble()로 만드는 것을 권장한다.
		System.out.println((int)oc.add(2.7,  4.5)); //입력한 숫자는 double이라 double메서드에서 계산하지만 결과는 int로 출력한다.
		System.out.println(oc.add((int)2.7,  (int)4.5)); //애초에 숫자를 int로 변환하였기 때문에 int 메서드에서 계산한다.
	}	
	
	//이곳 밑으로 각각의 메서드들을 만든다.
	public int add(int x, int y) {
		System.out.println("int 연산 실행: ");
		return x + y; 
	}
	public double add(double x, double y) {
		System.out.println("double 연산 실행: ");
		return x + y;
	}
	public String add(String x, String y) {
		System.out.println("String 연산 실행: ");
			return x + y;
	}
}
