<%@page import="com.webjjang.board1.vo.BoardVO"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%
//이 부분은 자바 코드 부분
String url = request.getServletPath();
@SuppressWarnings("unchecked")
List<BoardVO> list = (List<BoardVO>) ExeService.execute(Beans.get(url), null);
request.setAttribute("list", list);

//request.setAttribute("list", ExeService.execute(Beans.get(request.getServletPath(), null)));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>

<!-- Bootstrap 라이브러리 등록 : CDN방식 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
.dataRow:hover{
	cursor: pointer;
	background: #eee;
}
</style>
<script type="text/javascript">

$(function(){
	$(".dataRow").click(function(){
		var no = $(this).find(".no").text();
	});
});

</script>


</head>
<body>
<div class="container">
<h1>게시판 리스트</h1>
<table class="table">
	<!-- 제목 -->
	<thead>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
	</thead>
	
	<tbody>
	<!-- 데이터가 있는 만큼 반복 -->
		<c:forEach items="${list }" var = "vo">
		<tr class="dataRow">
			<td class="no">${vo.no }</td>
			<td>${vo.title }</td>
			<td>${vo.writer }</td>
			<td>${vo.writeDate }</td>
			<td>${vo.hit }</td>
		</tr>
		</c:forEach>
	</tbody>
	
	<tfoot>
		<tr>
			<td colspan="5">
				<a href="writeForm.jsp" class="btn btn-default">글쓰기</a>
			</td>
		</tr>
	</tfoot>

</table>
</div>
</body>
</html>