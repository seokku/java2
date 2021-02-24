<%@page import="com.webjjang.board1.vo.BoardVO"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//순수 자바 부분
//내가 만든 부분이 정말로 작동하는지 콘솔에서 확인한다
System.out.println("게시판 글쓰기 처리 중입니다. 글쓰기가 완료됐습니다.");

//입력받는 데이터 한글처리
request.setCharacterEncoding("utf-8");

//1. 데이터 수집
//데이터를 받는다
//제목, 내용, 작성자
String title = request.getParameter("title");
String content = request.getParameter("content");
String writer = request.getParameter("writer");
//vo 객체를 만들어 넣는다
BoardVO vo = new BoardVO();
//BoardVO 객체를 만들어 사용한다
//setter를 이용해서 넣는다
vo.setTitle(title);
vo.setContent(content);
vo.setWriter(writer);

//2. DB 처리
String url = request.getServletPath();
//DB에 데이터 저장하는 처리를 한다
//타입을 맞춰야하니 캐스팅을 해줘야 한다
Integer result = (Integer) ExeService.execute(Beans.get(url), vo);

//3. 글쓰기를 완료하면 list로 자동으로 이동하게 만든다
response.sendRedirect("list.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>