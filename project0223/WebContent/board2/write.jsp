<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.board2.vo.Board2VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//한글처리
request.setCharacterEncoding("utf-8");

String url = request.getServletPath();

//1. 데이터수집 - request객체.전달데이터가져오기(name명); 
String title = request.getParameter("title");
String content = request.getParameter("content");
String writer = request.getParameter("writer");


//vo객체를 만들어서 넣는다.
Board2VO vo = new Board2VO();
vo.setTitle(title);
vo.setContent(content);
vo.setWriter(writer);

// DB처리
ExeService.execute(Beans.get(request.getServletPath()), vo);

//2. DB처리 - write.jsp -> service -> dao
//int writeResult = (Integer) ExeService.execute(Beans.get(url), vo);
// Integer result = (Integer) ExeService.execute(Beans.get(url), vo);

//3. list로 자동 이동 
response.sendRedirect("list.jsp");
%>