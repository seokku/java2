<%@page import="com.webjjang.notice1.vo.NoticeVO"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

// 데이터를 받는다. -> 서버가 전달해 주는 request객체 안에 데이터가 들어가 있다.
// request객체.전달데이터가져오기(name명);
String url = request.getServletPath();

String title = request.getParameter("title");
String content = request.getParameter("content");
String startDate = request.getParameter("startDate");
String endDate = request.getParameter("endDate");
// vo객체를 만들어서 넣는다.
NoticeVO vo = new NoticeVO();
vo.setTitle(title);
vo.setContent(content);
vo.setStartDate(startDate);
vo.setEndDate(endDate);

// DB에 데이터를 저장하는 처리를 한다.
Integer writeResult = (Integer)ExeService.execute(Beans.get(url), vo);

// 처리를 한 후에 자동 리스트로 페이지 이동시킴.
response.sendRedirect("list.jsp");
%>
