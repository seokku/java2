package com.webjjang.notice3.service;

import com.webjjang.main.controller.Service;
import com.webjjang.notice3.dao.NoticeDAO;

public class NoticeListService implements Service {

	NoticeDAO dao;

	@Override
	public void setDAO(Object obj) {
		// TODO Auto-generated method stub

		this.dao = (NoticeDAO)dao;
		
	}

	@Override
	public Object service(Object obj) throws Exception {
		
		return dao.list();
	}
	
}
