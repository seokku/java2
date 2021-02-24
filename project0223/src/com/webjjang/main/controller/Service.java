package com.webjjang.main.controller;

public interface Service {

	public Object service(Object obj) throws Exception;		// service를 실행시키기 전에 받아온 obj를 전달
	
	public void setDAO(Object dao);		// DAO를 저장하기 위하여 선언
	
}
