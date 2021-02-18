package com.webjjang.bord.service;

import java.util.List;

import com.webjjang.bord.dao.BoardDAO;
import com.webjjang.bord.vo.BoardVO;

//MainController -> Controller -> [Service] -> DAO 의 구조로 실행

public class BoardListService {
	
	//다른 패키지에서 사용가능하도록 선언 -> public
	//List - 데이터의 목록 : 중복 허용을 하는 컬렉션
	//컨트롤러에서 모든 예외를 통합적으로 처리하므로 발생된 예외는 컨트롤러까지 던진다 => 메서드 뒤에 throws 키워드 이용
	public List<BoardVO> service() throws Exception{
		System.out.println("BoardListService.service() 실행중");
		
		//DAO로 이동해서 실행하기 위해 객체를 생성하고 호출한다.
		BoardDAO dao = new BoardDAO();
		return dao.list();
	}
	
}
