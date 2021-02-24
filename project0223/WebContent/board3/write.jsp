<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.board3.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 입력 받는 데이터의 한글처리
request.setCharacterEncoding("utf-8");
// 1. 데이터 수집 - request객체.전달데이터가져오기(name명);
String title = request.getParameter("title");
String content = request.getParameter("content");
String writer = request.getParameter("writer");
// vo객체를 만들어서 넣는다.
BoardVO vo = new BoardVO();
vo.setTitle(title);
vo.setContent(content);
vo.setWriter(writer);

// 2.DB 처리 - write.jsp -> service -> dao
ExeService.execute(Beans.get(request.getServletPath()), vo);

// 3.처리를 한 후에 자동 리스트로 페이지 이동시킴.
response.sendRedirect("list.jsp");
%>