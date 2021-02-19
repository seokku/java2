<%@page import="com.webjjang.board.vo.BoardVO"%>
<%@page import="com.webjjang.board.service.BoardWriteService"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 
//----------- 데이터 처리 
//요청한  url 가져오기
//String url = request.getRequestURL().toString();
String url = request.getServletPath();
//생성되어 있는 서비스를 url에 맞는것을 찾아서 실행할 수 있도록 전달한다. - 생성하지 않는다.

//request객체.전달데이터가져오기(name명);
String title = request.getParameter("title");
String content = request.getParameter("content");
String writer = request.getParameter("writer");

//vo객체를 만들어서 넣는다.
BoardVO vo = new BoardVO();
vo.setTitle(title);
vo.setContent(content);
vo.setWriter(writer);

//DB에 데이터를 저장하는 처리를 한다.
int writeResult = (Integer) ExeService.execute(Beans.get(url), vo);

// 자동으로 리스트로 이동시킨다.
response.sendRedirect("list.jsp");
%>
