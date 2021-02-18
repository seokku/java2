package ch07Inheritace;

public class Car {
	
	private String model;
	private String company;
	
	//생성자 만들기
	//기본 생성자
	public Car() {
	}
	//데이터 초기화하는 생성자
	public Car (String model, String company) {
		this.model = model;
		this.company = company;
	}
	
	//getter()와 setter()
	public String getModel() { //model에 대한 getter()
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getCompany() { //company에 대한 getter()
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public void start() {
		System.out.println("출발한다.");
	}
	
	public void stop() {
		System.out.println("멈춘다.");
	}
	
	public String toString() {
		System.out.println("Car.toString() 실행중");
		return "model=" + model + ", company=" + company;
	}
}
