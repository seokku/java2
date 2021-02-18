package com.webjjang.bord.dao;

import java.util.ArrayList;
import java.util.List;

import com.webjjang.bord.vo.BoardVO;

//MainController -> Controller -> Service -> [DAO] 의 구조로 실행
public class BoardDAO {
	
	//다른 패키지에서 접근 가능 : public
	//처리하고 나면  BoardVO가 여러 개 담겨져 있는 컬렉션(List)를 리턴해준다.
	//메서드이름은 list()
	//DB처리를 해서 리스트 데이터를 가져와서 리턴해 준다.
	public List<BoardVO> list(){
		System.out.println("BoardDAO.list() 실행 중");
		List<BoardVO> list = null; // 데이터를 저장할 객체 선언
		//데이터 DB에서 가져와서 list에 넣어준다 -> 강제로 데이터 처리
		//1.list 객체 생성
		list = new ArrayList<BoardVO>();
		
		//2.데이터를 가져온다
		//  -데이터를 저장할 vo 객체 생성
		BoardVO vo1 = new BoardVO();
		//  -데이터 강제 입력 : 글번호, 제목, 작성자, 작성일, 조회수
		vo1.setNo(10);
		vo1.setTitle("자바");
		vo1.setWriter("김예림");
		vo1.setWriteDate("2020.12.31");
		vo1.setHit(100);
		
		list.add(vo1);
		
		//  -데이터를 저장할 vo 객체 생성
		BoardVO vo2 = new BoardVO();
		//  -데이터 강제 입력 : 글번호, 제목, 작성자, 작성일, 조회수
		vo2.setNo(9);
		vo2.setTitle("오라클");
		vo2.setWriter("김채림");
		vo2.setWriteDate("2020.12.30");
		vo2.setHit(150);
		
		list.add(vo2);
		
		
		//데이터가 잘 담겨져있는지 출력
		System.out.println("BoardDAO.list().list 실행 함" + list);
		return list;
	}
	
	public BoardVO view(long no) throws Exception{
			System.out.println("BoardDAO.view() 실행중");
			
			BoardVO vo = new BoardVO();
			//값을 셋팅
			vo.setNo(10);
			vo.setTitle("자바");
			vo.setContent("자바짱");
			vo.setWriter("이영환");
			vo.setWriteDate("2020.12.31");
			vo.setHit(100);
			
			//출력 테스트
			System.out.println("BoardDAO.view().view.vo 실행 함" + vo);
			return vo;
	}
	
}
