
public class InstanceOfOp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name ="김예림";
		System.out.println("name의 값 :" + name);
		
		//name이라는 변수가 String인지 알고 싶다.
		System.out.println("name이 Stringd이 맞는가 :" + (name instanceof String));
		
		//게시판 - no, title, content, writer, writeDate, hit
		//공지사항 - no, title, content, startDate, endDate, writeDate
		
	}

}
