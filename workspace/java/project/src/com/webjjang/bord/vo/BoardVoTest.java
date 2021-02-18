package com.webjjang.bord.vo;

public class BoardVoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//기본생성자 테스트
		BoardVO boardVO= new BoardVO();
		//boardVO.no = 1; => private가 있어서 안 됨
		//값을 넣는다 - setter를 이용한다.
		boardVO.setNo(1);
		boardVO.setTitle("java");
		boardVO.setContent("java jjang");
		boardVO.setWriter("kim");
		boardVO.setWriteDate("2020.12.23");
		boardVO.setHit(10);
		
		//데이터를 사용하기 위해서 getter를 이용한다.
		
		//글번호 출력
		System.out.println("글번호 : " + boardVO.getNo());
		
		//boardVO라는 객체에 데이터가 잘 들어가 있는지 확인해보자
		System.out.println(boardVO.toString());
		System.out.println(boardVO);
		
		
		
		//기본 생성자가 아닌 생성자의 테스트
		//값이 이미 정해져 있어서 객체를 생성하면서 데이터를 초기화시킬 수 있다.
		BoardVO boardVO1 = new BoardVO(10, "test", "test", "kim", "20.12.23", 20);
		BoardVO boardVO2 = new BoardVO(10, "test", "test", "kim", "20.12.23", 20);
		//출력하는데 객체이름만 사용한 경우 toString 메서드를 자동 호출한다.
		System.out.println(boardVO1);
		System.out.println("==로 비교:" + (boardVO1 == boardVO2));
		System.out.println("equals()로 비교:" + (boardVO1.equals(boardVO2)));
		
		System.out.println("boardVO1.hashcode() : " + boardVO1.hashCode());
		System.out.println("boardVO2.hashcode() : " + boardVO2.hashCode());
		
		System.out.println(System.identityHashCode(boardVO1));
		System.out.println(System.identityHashCode(boardVO2));
	}

}
