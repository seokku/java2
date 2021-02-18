
public class Object1 {

	//변수 = 필드 = 객체 변수 = 속성 = 전역변수(어디서든 사용가능)= 멤버변수	
	//non-static : new로 생성한 다음에 사용 가능(객체변수.age;)
	private int age; //기본 초기값=0
	private String name; //기본 초기값 = null
	
	//static : 이름만 나타나면 바로 사용 가능 (Object1.company;)
	static String company; //기본초기값 = null
	
	//static 초기화 블록
	static {
		//클래스의 이름이 나타나면 바로 자동으로 실행되는 부분
		//static으로 선언된 변수의 값을 셋팅하기 위해서 (초기값을 주기 위해서) 사용된다.
		System.out.println("Object1.static 초기화 블록");
		//age = 28; static이 먼저 올라가고 나머지는 new를 해야 나타나므로 접근할 수 없다.
		company = "웹짱주식회사";
	}
	
	//초기화 블록
	{
		//new로 생성을 할 때마다 한 번 실행
		//static 이나 non-static으로 선언된 변수의 초기값을 셋팅하기 위해서 사용된다.
		System.out.println("Object1 초기화 블록");
		age = 23;
		name = "김예림";
		company = "(주)웹짱";
	}
	
	
	//기본 생성자 - 생성을 먼저 하고 나중에 값을 전달해서 셋팅, 클래스 이름과 같아야 함, 생략가능하고 생략하면 다른 생성자가 없는 경우에 컴파일러가 자동으로 생성해준다.
	public Object1() {
		System.out.println("기본생성자------------------------");
	}
	//생성자를 갖고 있음 - 생성을 할 때 값을 전달해서 초기값을 셋팅하기 위해 사용, 셋팅할 값이 이미 정해져 있어야 한다.
	public Object1(String name) {
		this.name = name;
		System.out.println("name을 받는 생성자 실행---------------------------");
	}
	public Object1(int age, String name) {
		this(name); //생성자의 호출을 이용해서 초기값 셋팅, 생성자 호출은 맨 위에 존재해야만 한다.
		this.age = age;
		//this.name = name;
		System.out.println("나이와 이름을 받는 생성자실행------------------------");
	}

	//getter와 setter을 이용한 데이터 사용과 변경 - 캡슐화, Object1에서 선언한 변수가 private이어야 한다.
	//문제 : int age에 대한 getter와 setter를 작성하시오.
	public int getAge() {
		return age; 
		}
	public void setAge(int age) { 
		System.out.println("Object1.setAge() 호출해서 실행중...");
		this.age = age;
	}
	public String getName() { 
		return name; 
		}
	public void setName(String name) { 
		this.name = name; 
		}
	
	//데이터 확인용 메서드
	public String toString() {
		return "Object1[age=" + age + ", name=" + name + ", company=" + company + "]";
	}
	
}
