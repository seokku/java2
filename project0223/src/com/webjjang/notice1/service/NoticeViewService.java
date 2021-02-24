package com.webjjang.notice1.service;

import com.webjjang.main.controller.Service;
import com.webjjang.notice1.dao.Notice1DAO;

public class NoticeViewService implements Service {
	
	Notice1DAO dao;
	
	@Override
	public void setDAO(Object dao) {
		// TODO Auto-generated method stub
		this.dao = (Notice1DAO) dao;
	}
	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
	}



}
