package ch08Interface;

public interface FourOpInterface {
	
	//단순 4칙연산 메서드 만들기
		public abstract int add(int x, int y); //모두 abstract 이므로 interface는 abstract를 사용해도 되고 사용하지 않아도 된다.
		public int sub(int x, int y);
		//default 메서드 : 자바 8부터 구현이 가능, adeptor 프로그램에서 기본 메서드로 구현하던 것을 합쳐놓은 것
		//상속받은 자식 클래스에서 재정의하여 사용하면 재정의한 것을 사용하고 아니면 기본 메서드(default)를 사용
		public int mul(int x, int y);
		public int div(int x, int y);
		
}
