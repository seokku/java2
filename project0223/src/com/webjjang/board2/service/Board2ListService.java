package com.webjjang.board2.service;

import com.webjjang.board2.dao.Board2DAO;
import com.webjjang.main.controller.Service;

public class Board2ListService implements Service{
	
	private Board2DAO dao;
	
	@Override
	public void setDAO(Object dao) {
		this.dao = (Board2DAO) dao;
	}
	
	@Override
	public Object service(Object obj) throws Exception {
		return dao.list();
	}
}
