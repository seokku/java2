
public class Car { //변수들... 메서드()들...
	
	//Car 안에 생성자가 없으면 컴파일러가 기본 생성자를 만들어 준다. 보통은 생략
	//Car(){} - () 사이에 매개변수가 비어있음. {}가 비어있음 -> 기본생성자 : 컴파일러가 자동적으로 추가 싴켜준다
	//기본 생성자를 수동으로 만들어 보자 -> 사용하려면 new Car()
	//클래스 이름과 동일하다. 리턴타입이 없다 -> 메모리에 올리고 주소를 전달한다.
	public Car() {}
	
	//변수들... 메서드()들...
	String company = "현대 자동차";
	String model = "그렌져";
	
	//제작사와 모델을 출력하는 프로그램 작성
	public void print() {
		System.out.println("Car.print()");
		System.out.println("제조사:" + company);
		System.out.println("차종:" + model);
	}
	
}
