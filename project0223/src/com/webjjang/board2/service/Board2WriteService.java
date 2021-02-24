package com.webjjang.board2.service;

import com.webjjang.board2.dao.Board2DAO;
import com.webjjang.board2.vo.Board2VO;
import com.webjjang.main.controller.Service;

public class Board2WriteService implements Service{
	
	//dao가 필요하다. 밖에서 생성한 후 넣어준다. -1. 생성자. 2. setter()
	private Board2DAO dao;
	
	
	@Override
	public void setDAO(Object dao) {
		this.dao = (Board2DAO) dao;
		System.out.println(this.dao);
	}

	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.write((Board2VO) obj);
	}

}