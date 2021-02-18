package ch07Inheritace;

public class Car2 {
	
	private String model;
	private String company;
	
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
}
