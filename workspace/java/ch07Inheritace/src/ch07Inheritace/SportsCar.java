package ch07Inheritace;

public class SportsCar extends Car {
	
	
	//기본생성자 생략된 거 작성
	public SportsCar() {
		//Car(); -> 메서드로 인식, 부모 클래스의 생성자 호출은 super() 이용 <-> this() 이용
		super();
	}
	
	//모델과 제조사를 초기값으로 받는 생성자 작성
	public SportsCar(String model, String company) {
		super(model, company);
		//this.model=model; -> super 상속받은 model은 private로 선언했기 때문에 상속할 수 없다.
		//this.setModel(model);
	}
	
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	//toString() 재정의 : 오버라이드
	public String toString() {
		System.out.println("SoprtsCar.toString()를 실행중");
		return "SprotsCar[" + super.toString() + ", type=" + type+ "]"; //type은 이 파일 안에 선언했기 때문에 호출 필요없음, Car에 있는 toString() 호출
	}
	
}
