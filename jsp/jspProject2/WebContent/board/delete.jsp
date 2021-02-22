<%@page import="com.webjjang.board.vo.BoardVO"%>
<%@page import="com.webjjang.board.service.BoardWriteService"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
// 한글처리
request.setCharacterEncoding("utf-8");

//생성되어 있는 서비스를 url에 맞는것을 찾아서 실행할 수 있도록 전달한다. - 생성하지 않는다.

// 1. 데이터수집 - request객체.전달데이터가져오기(name명);
String strNo = request.getParameter("no");
long no = Long.parseLong(strNo);

//2. DB처리 - delete.jsp -> service -> dao
String url = request.getServletPath();
// int writeResult = (Integer) ExeService.execute(Beans.get(url), vo); 
Integer result = (Integer) ExeService.execute(Beans.get(url), no);

// 3. list로 자동 이동 
response.sendRedirect("list.jsp");
%>
