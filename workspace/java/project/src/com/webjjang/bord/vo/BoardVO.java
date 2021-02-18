package com.webjjang.bord.vo;

//public : 공용 - 다른 패키지에서 모두 사용 가능하다.(생성, 상속)
//protected : 약간의 보호 - 다른 패키지에서 생성은 안돼서 상속은 가능하다.
//default : 기본 - 다른 패키지에서 사용 불가, 같은 패키지에서는 사용 가능
//private : 개인 - 현재 클래스 내에서만 사용 가능 (밖에서 접근하는 메서드 작성 : getter(), setter()를 작성해서 정보를 처리한다.)
public class BoardVO {

	//글번호, 제목, 내용, 작성자, 작성일, 조회수
	private long no;
	private String title;
	private String content;
	private String writer;
	private String writeDate;
	private long hit;
	
	//생성자 - 초기값 셋팅을 위해서 만든다. - 생성할 때 딱 한 번만 실행
	//같은 이름의 생성자를 여러개 만들어서 사용할 수 있도록 지원하는데 이런것을 overload라고  한다.
	//파라메터의 갯수와 순서의 타입이 다르면 다른 것으로 인식한다.
	//먼저 생성을 하고 데이터를 나중에 넣는 방식을 사용하려고 하면 기본생성자를 이용하면 기본 초기값이 들어간다 - 생략 가능
	public BoardVO() {}
	
	//값이 먼저 주어지고 객체 생성을 하면서 데이터를 가지고 초기화 시킬 수 있다. - 초기화 시키려는 값을 받는다
	//특징 - 클래스 이름과 같다. 리턴 타입이 없다.
	//생성자가 하나 선언이 되면 기본 생성자를 자동으로 만들지 않는다.
	
	public BoardVO(long no, String title, String content, String writer, String writeDate, long hit) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = writeDate;
		this.hit = hit;
	}
	//글쓰기 - 제목, 내용, 작성자
	//글쓰기 생성자 만들기
	public BoardVO(String title, String content, String writer) {
		this(0, title, content, writer, null, 0); //초기값들 '
		//생성자의 호출을 먼저 사용하고 그리고 나서 나머지 처리문을 해야만 한다.
	}
	//글수정 생성자 만들기 - 글번호, 제목, 내용, 작성자
	public BoardVO(long no, String title, String content, String writer) {
		this(no, title, content, writer, null, 0);
	}
	
	//getter와 setter - property
	//getter의 경우 변수가 없을 수도 있다. - 예) 생년월일을 이용해서 나이를  줄 수도 있다.
	//=> getAge(){생년월일을 이용해서 나이를 계산한 결과를 리턴}
	//getter : 안에 있는 데이터를 밖으로 전달
	public long getNo() {
		return no;
	}	
	//setter : 밖에서 데이터를 전달해서 안에 저장
	public void setNo(long no) {
		this.no = no; //this.no : 같은 클래스 안에 있는 no를 가져온다.
	}
	
	public String getTitle() {
		return title;
	}	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getWriter() {
		return writer;
	}	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	
	public long getHit() {
		return hit;
	}
	public void setHit(long hit) {
		this.hit = hit;
	}
	
	
	//객체 변수 이름을 출력하면 자동으로 호출당하는 메서드 :Object 안에 있는 것을 재정의
	//-이런 프로그램들은 이미 작성이 되어 있다.
	@Override //Override 어노테이션(@) - 상속받은 메서드의 재정의 이여야만 한다.
	public String toString() {
		return "BoardVO[no=" + no + ", title=" + title + ", content="
	+ content + ", writer=" + writer + ", writeDate=" + writeDate +
	", hit=" + hit+ "]";
	}
	
	//equals() 오바리이딩 객체가 같다라는 의미 : 글번호와 작성자가 같다. =>같은 객체면 (true) 추출
	//Object에 있는 똑같은 메서드를 오버라이드(재정의) 사용한 것이다.
	//Object에서는 ==로만 비교해서 리턴해 준다. 참조형 변수인 경우에는 주소값을 비교하게 돼서 
	//값이 같더라도 주소는 틀리기 때문에 다른 것으로 결과가 나오게 돼서 false를 리턴한다.
	//그러나 BoardVO1과 BoardVO2를 비교하는데 그 안에 있는 값이 같다면 같은 것으로 처리해야만 한다.
	@Override
	public boolean equals(Object obj) {
		BoardVO boardVO = (BoardVO) obj; //강제 캐스팅
		if(no != boardVO.getNo()) //글번호가 틀리면 안된다. -false
			return false;
		else if(writer.equals(boardVO.getWriter())) //작성자가 틀리면 안된다. -false
			return false;
		else return true;//글번호가 맞고 작성자도 맞다. -true
	}
	
}
