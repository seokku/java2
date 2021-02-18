
public class Singleton {
	//2.저장해서 저장해둔다.
	private static Singleton singleton = new Singleton();
	
	//1.prinvate-같은 클래스에서만 생성 가능
	private Singleton() {
		
	}
	
	//3.다른 곳에서 값(주소)을 가져갈 수 있는 메서드를 만든다.
	public static Singleton getInstance() {
		return singleton;
	}
}
