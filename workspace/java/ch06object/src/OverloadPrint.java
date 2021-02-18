//이 코드 전부가 op
public class OverloadPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "김예림";
		int age = 23;
		OverloadPrint op = new OverloadPrint();
		op.print(name);
		op.print(age);
	}

	//변수 이름과 파라메터 갯수는 같지만 파라메터의 타입이 틀려서 overload 시켜준다.
	//데이터를 전달해서 출력한다
	public void print(String str) { //문자열 str을 받아서
		System.out.println("문자열 출력 : " + str); //출력
	}
	
	//변수 이름과 파라메터 갯수는 같지만 파라메터의 타입이 틀려서 overload 시켜준다.
	//데이터를 전달해서 출력한다.
	public void print(int x) { //데이터 x를 받아서
		System.out.println("int 출력 : " + x); //출력
	}
}
