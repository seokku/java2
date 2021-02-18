package com.webjjang.bord.service;

import com.webjjang.bord.dao.BoardDAO;
import com.webjjang.bord.vo.BoardVO;

//MainController -> Controller -> [Service] -> DAO 의 구조로 실행

public class BoardViewService {

	public BoardVO service(long no) throws Exception{
		System.out.println("BoardViesService.service().no 실행중 : " + no);
		
		BoardDAO dao = new BoardDAO();
		return dao.view(no);
		
	}

}
