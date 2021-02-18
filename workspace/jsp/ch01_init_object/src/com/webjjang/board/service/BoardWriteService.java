package com.webjjang.board.service;

import com.webjjang.board.dao.BoardDAO;
import com.webjjang.main.controller.Service;

public class BoardWriteService implements Service {
	

	// DB 처리를 위한 DAO
	private BoardDAO dao; // 기본값은 null이 된다.
	
	@Override
	// DAO를 넣어주는 setter -> 밖에서 생성을 해서 넣어준다.(바뀐부분)
	public void setDAO(Object dao) throws Exception{
		this.dao = (BoardDAO)dao;
	}


	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BoardWriteService.service() - 게시판 글쓰기 처리");
		return dao.write();
	}

}
