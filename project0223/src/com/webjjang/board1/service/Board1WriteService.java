package com.webjjang.board1.service;

import com.webjjang.board1.dao.Board1DAO;
import com.webjjang.board1.vo.Board1VO;
import com.webjjang.main.controller.Service;

public class Board1WriteService implements Service{
	
	//dao가 필요하다 -> 밖에서 생성한 후 넣어준다--> 1. 생성자 2.setter()
	//실행은 서버가 시작될 때 시작
	private Board1DAO dao;
	
	@Override
	public void setDAO(Object dao) {
		this.dao = (Board1DAO) dao;
	}
	
	@Override
	public Object service(Object obj) throws Exception{
		return dao.write((Board1VO) obj);
	}

}
