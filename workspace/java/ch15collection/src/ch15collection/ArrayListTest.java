package ch15collection;

import java.util.ArrayList;
import java.util.List;

//Collection에서 List를 상속받은 ArratList : 데이터 나열 - 배열로 운영(검색이 빠른 장점, 데이터가 자주 수정이 되면 느려지는 단점)
public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//13장 제네릭 : 저장 장소(변수)의 타입을 밖에서 선언해서 그 타입에 맞는 것만 저장할 수 있도록 변수 타입에 대한 코드를 만들어 주는 것
		//모든 데이터를 저장 가능하게 하는 Object
		//List<'배열에 들어갈 타입'>
		List<Object> list = new ArrayList<>();   //import를 해야한다->ctrl+space(List와 ArrayList 두 번)
		
		//list에 개인 정보를 저장해 보자.
		list.add("김예림"); //String -> Object : Object를 상속받았기 때문에 자동캐스팅(String<Object)
		//int의 랩퍼클래스 : Integer - int 를 안에 가지고 있으면서 처리를 가능하게 하는 클래스
		//int <=> Integer - 캐스팅 없이 사용 가능. 박싱, 언박싱이 자동으로 이루어 진다.(오토박싱, 오토언박싱)
		int x = 23;
		Integer xi = x; //오토박싱, int -> Integer실행
		x = xi; //오토언박싱, Integer -> int
		list.add(xi);
		list.add(23); //int -> Integer -> Object
		
		boolean gender = true;
		Boolean genderB = gender; //오토박싱, gender을 가져와서 gender라는 클래스로 가져간다.
		list.add(genderB);
		list.add(gender); //boolean -> Boolean -> Object
		
		System.out.println(list);
		
		
		
		//문자열만 저장할 수 있는 list
		List<String> stringList = new ArrayList<>();
		stringList.add("이젠");
		//stringList.add(10);  => stringList는 String만 저장할 수 있도록 제네릭했기 때문에 숫자를 넣으면 오류가 난다.
			
		//int만 저장할 수 있는 list
		//List<int> intList = new ArrayList<E>();  => list객체는 Object만 상대, 선언할 때 Object가 아닌 int로 할 수 없다.
		List<Integer> intList = new ArrayList<>();
		intList.add(10); // 10 : int -> Integer로 자동캐스팅
		
		//BoardVO만 저장할 수 있는 list
		//list 안에 아무거나 넣어놓으면 데이터를 꺼내서 사용을 하려고 하면 
		List<BoardVO> boardList = new ArrayList<>();
		BoardVO vo1 = new BoardVO();
		vo1.setNo(100);
		boardList.add(vo1);
		//boardList.add("김예림"); //BoardVOo 데이터가 아니면 오류가 난다.
		boardList.add(new BoardVO()); //no는 기본 초기값인 0이 들어간다.
		System.out.println(boardList);
		System.out.println(boardList.size());
		
		//데이터를 한 개씩 꺼내서 출력하는 프로그램 작성
		for(int i = 0; i < boardList.size(); i++) {
			//객체가 출력된다.
			System.out.println(boardList.get(i));
			//객체 안에 있는 no 출력
			System.out.println(boardList.get(i).getNo());
		}
		
		//주소를 꺼내와서 내용을 변경하면 원래의 것인 주소를 찾아가면 같은 주소이므로 변경된 내용으로 사용이 된다.
		boardList.get(1).setNo(500); //1번째 주소를 따라가 저장되어있는 값을 바꾼다.
		//데이터를 한 개씩 꺼내서 출력하는 프로그램 작성
		for(int i = 0; i < boardList.size(); i++) {
			//객체가 출력된다.
			System.out.println(boardList.get(i));
			//객체 안에 있는 no 출력
			System.out.println(boardList.get(i).getNo());
				}
		
		//실제적으로는 가져온 모든 데이터를 대상으로 데이터 출력 -> foreach == 향상된for문
		for(BoardVO vo : boardList) {
			System.out.println(vo.getNo());
		}
		
	}//end of main()
		
}//end of class()

//클래스 - 위에 클래스에서 서로 연관되어 있는 것을 꺼내서 독자적으로 동작을 하는 것을 모아둔 것, 위의 public 클래스에서 주로 사용하는 경우가 많다.)
//컴파일을 하면 클래스 파일이 따로 만들어 진다.
class BoardVO{
	private int no;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
}
