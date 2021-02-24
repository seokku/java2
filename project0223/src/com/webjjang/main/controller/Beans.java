package com.webjjang.main.controller;

import java.util.HashMap;
import java.util.Map;

public class Beans {

	private static Map<String, Service> serviceMap = new HashMap<>();
	
	private static Map<String, Object> daoMap = new HashMap<>();
	
	public static Service get(String key) {		// service 객체에서 가져오기
		
		return serviceMap.get(key);
		
	}
	
	public static void put(String key, Service service) {	// key 값에 service 저장하기
		
		serviceMap.put(key, service);
		
	}
	
	public static Object getDAO(String key) {		// dao 객체 가져오기
		
		return daoMap.get(key);
		
	}
	
	public static void putDAO(String key, Object dao) {		// key 값에 dao 저장하기
		
		daoMap.put(key, dao);
		
	}
	
}
