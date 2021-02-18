
public class Object1Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Object1Test.main() - 시작");
		Object1 obj1;
		try {
			//클래스가 실제로 존재하는지 확인하는 코드 - 존재여부만 확인하는 것이 아니라 static 초기화 블록이 실행 또는 메모리에 올라간다.
			Class.forName("Object1");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		obj1 = new Object1();
		
		System.out.println("기본생성자를 이용한 obj1[main에서 출력]: " + obj1);
		//값을 변경
		obj1.setAge(40);
		System.out.println("나이를 40으로 변경한 obj1[main에서 출력]: " + obj1);
		
		int age = 30;
		String name = "홍길동";
		Object1 obj2 = new Object1(age, name);
		
		System.out.println("나이와 이름을 전달받은 생성자 obj2[main에서 출력]: " + obj2);
	}
	
}
