
public class StringExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String strVar1 = "김예림";
		String strVar2 = "김예림";
		
		System.out.println(strVar1 + "-1/" + strVar2 + "-2");
		System.out.println(strVar1 == strVar2);
		
		String strVar3 = new String("김예림");
		String strVar4 = new String("김예림");
		
		System.out.println(strVar3 + "-new 3/" + strVar4 + "-new 4");
		System.out.println(strVar3 == strVar4); //주소가 달라서 false 가 나옴
		
		System.out.println(strVar1 + "-1/" + strVar3 + "-new 3");
		System.out.println(strVar1 == strVar3); //주소가 달라서 false 가 나옴
				
		//무조건 문자열이나 클래스의 값으로 비교할 때는 equals()를 사용해야한다.
		//-이때 프로그램은 작성되어 있어야 한다.
		
		//문자열 String의 비교는 ==로 비교하면 주소를 비교하게 되므로 equals()로 비교해야한다.
		System.out.println(strVar1 + "-1/" + strVar3 + "-new 3 :equals 비교");
		System.out.println(strVar1.equals(strVar3)); //equals()는 값으로 비교
		
		System.out.println(strVar3 + "-new 3/" + strVar4 + "-new 4 :equals 비교");
		System.out.println(strVar3.equals(strVar4));
		
		System.out.println(strVar1 + "-1/" + strVar2 + "-2 :equals 비교");
		System.out.println(strVar1.equals(strVar2));
	}

}
