<%@page import="com.webjjang.notice1.vo.notice1VO"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// 여기가 자바 코드입니다. JSP ~> Service ~> DAO -> /board/view.jsp
String url = request.getServletPath();

// 넘어오는 데이터 받기 - 글 번호
String strNo = request.getParameter("no");
long no = Long.parseLong(strNo);

notice1VO vo = (notice1VO)ExeService.execute(Beans.get(url),no);
// 서버객체 request에 담는다.
request.setAttribute("vo", vo);
%>  
<%=vo %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지1 보기</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>

<body>
<div class="container">
<h1>공지 글 보기</h1>
<table class="table">
	<tbody>
		<tr>
			<th>글 번호</th>
			<td class="no">${vo.no }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${vo.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><pre style="background: #fff; border: none; padding: 0px;">${vo.content }</pre></td>
		</tr>
		<tr>
			<th>공지 시작일</th>
			<td>${vo.startDate }</td>
		</tr>
		<tr>
			<th>공지 종료일</th>
			<td>${vo.endDate }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${vo.writeDate }</td>
		</tr>
		<tr>
			<th>최근 수정일</th>
			<td>${vo.updateDate }</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="2">
				<a href="list.jsp" class="btn btn-default">리스트</a>
			</td>
		</tr>
	</tfoot>
</table>
</div>
</body>
</html>