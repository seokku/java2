package com.webjjang.notice2.service;

import com.webjjang.main.controller.Service;
import com.webjjang.notice2.dao.Notice2DAO;

public class Notice2ViewService implements Service {
	
	// dao가 필요하다. 밖에서 생성한 후 넣어준다. - 1. 생성자 2. setter()
	private Notice2DAO dao;
	@Override
	
	public void setDAO(Object dao) {
		this.dao = (Notice2DAO) dao;
	}

	@Override
	public Object service(Object obj) throws Exception {
		
		return dao.view((Long) obj);
	}

}
