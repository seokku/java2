
public class AutoInitaValue {

	//위치 상 : 전역 변수 => 클래스 안에 있는 필드=항목=속성 => 객체가 가지고 있는 변수 : 객체변수
	//초기값을 지정하지 않음 => 기본값으로 자동 셋팅된다.
		static int a;
		static boolean b;
		static String str;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("전역 변수 출력 : int - " + a + ", boolean - " + b + ", String - " + str);	
		
		
		//main 안에서만 접근이 되는 지역변수
		//초기값을 지정하지 않음  => 자동 초기화싴켜주지 않는다. 오류나면서 초기값을 넣으라고 한다
		//=> 이 변수들을 사용하려면 강제적으로 초기값을 셋팅하여야만이 사용할 수 있다.
		int a2 = 0;
		boolean b2 = false;
		String str2 = null;
		
		System.out.println("전역 변수 출력 : int - " + a2 + ", boolean - " + b2 + ", String - " + str2);
	}

}
