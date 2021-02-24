<%@page import="com.webjjang.notice1.vo.NoticeVO"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String url = request.getServletPath();
@SuppressWarnings("unchecked")
List<NoticeVO> list = (List<NoticeVO>)ExeService.execute(Beans.get(url), null);

request.setAttribute("list", list);
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 리스트</title>

  <!-- BootStrap 라이브러리 등록 : CDN 방식 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
/* 선택자 - tr : tag, .tr : class, #tr : id */
.dataRow:hover{
	/* 배경색 회색으로 변경 */
	background: #eee;
	/* 마우스 커서를 손가락으로 변경 */
	cursor: pointer;
}
</style>

<script type="text/javascript">
/* 함수가 없으면 그냥 실행이 됨. <body>보다 먼저 실행되므로 객체 찾을 수 없다. - $() -> jQuery 함수 */


$(function(){
	$(".dataRow").click(function(){
		// location.href 에 url을 넣는다. -> 페이지 이동이 생긴다.
		// this --> tr객체. this 안에 클래스로 no --> td 객체가 있다. 그안에 있는 글자가 글번호이다.
		// .fine(찾는객체) - 선택된 객체안에서 객체 찾기
		// .text() - 객체(태그) 안에 있는 글자만 가져오기
		location = "view.jsp?no=" + $(this).find(".no").text();
	});
});
</script>

</head>
<body>
<div class="container">
<h1>공지 리스트</h1>
<table class="table">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>공지시작일</th>
	<th>공지종료일</th>
	<th>최종수정일</th>
</tr>

<c:forEach items="${list }" var="vo">
<tr class="dataRow">
	<td class="no">${vo.no }</td>
	<td>${vo.title }</td>
	<td>${vo.startDate }</td>
	<td>${vo.endDate }</td>
	<td>${vo.updateDate }</td>
</tr>
</c:forEach>

<tr>
	<td colspan="5">
		<a href="writeForm.jsp" class="btn btn-default btn-sm">쓰기</a>
</table>
</div>
</body>
</html>