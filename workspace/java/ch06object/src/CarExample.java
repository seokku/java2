
public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//class Car를 사용해야 한다. ->생성 ->호출
		//new : 객체 생성
		//new 뒤에 있는 Car() -> 생성자(생성할 때 사용하는 것)
		Car myCar = new Car();
		System.out.println(myCar);
		
		//차종 출력
		System.out.println(myCar.model);
		myCar.model = "산타페";
		System.out.println(myCar.model);
		//print()를 호출 -> 그 메서드로 가서 실행하고 다시 돌아온다.
		myCar.print();
		System.out.println("다시 여기는 main()입니다.");
	}

}
