package com.webjjang.main.controller;

public class ExeService {

	public static Object execute(Service service, Object obj) throws Exception {
		
		System.out.println("실행되는 객체 : " + service.getClass().getSimpleName() + ".service");	// 현재 실행되고 있는 서비스 위치 출력
		
		System.out.println("전달되는 Data" + obj);		// 전달하는 data 출력
		
		Object result = service.service(obj);		// service 실행
		
		System.out.println("실행한 결과 : " + result);	// service의 결과값 출력
		
		return result;	// 실행한 결과값을 리턴해 준다.
		
	}
	
}
