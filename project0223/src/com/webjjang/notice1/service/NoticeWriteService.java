package com.webjjang.notice1.service;

import com.webjjang.notice1.dao.Notice1DAO;
import com.webjjang.notice1.vo.NoticeVO;
import com.webjjang.main.controller.Service;

public class NoticeWriteService implements Service {
	
	// dao가 필요하다. 밖에서 생성한 후 넣어준다. - 1. 생성자 2. setter()
	private Notice1DAO dao;
	@Override
	
	public void setDAO(Object dao) {
		this.dao = (Notice1DAO) dao;
	}

	@Override
	public Object service(Object obj) throws Exception {
		// TODO Auto-generated method stub
		return dao.write((NoticeVO) obj);
	}

}
