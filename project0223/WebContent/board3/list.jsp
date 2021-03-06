<%@page import="java.util.List"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// 여기가 자바 코드 입니다. JSP -> service -> DAO
	// String url = request.getServletPath();
	// @SuppressWarnings("unchecked")
	// List <BoardVO> list = (List <BoardVO>) ExeService.execute(Beans.get(url), null);
	// 서버객체 request에 담는다.
// ExeService.execute(Beans.get(request.getServletPath()) 이렇게 사용을 하면 캐스팅을 안해도 된다.
request.setAttribute("list", ExeService.execute(Beans.get(request.getServletPath()), null));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게 시 판 3 리 스 트</title>
  <!-- CDN 방식 부트스트랩 라이브러리 등록 -->
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
// 객체 선택에 문제가 있다.아래 Document가 다 로딩이 되면 실행이 되는 스크립트 작성
// jQuery -> $(function(){처리문 만들기;}) = jQuery(function(){처리문 만들기;})
$(function(){ // jQuery에서 익명함수를 전달해서 저장해 놨다가 Document가 로딩이 다되면 호출해서 처리해준다.
	// 데이터 한줄 선택하기와 이벤트 처리 
	$(".dataRow").click(function(){
// 		alert($(this));
		// $(this) : 이벤트가 일어난(현재 처리되고 있는 객체) 자신을 의미
		// .find(selector) : .앞에 객체 안에서 선택한 것을 찾아라.
		// .text() : 객체(태그) 사이에 있는 문자 가져오기
		// .text(data) : 객체(태그) 사이에 문자를 세팅한다.
		var no = $(this).find(".no").text();
		location = "view.jsp?no=" + no + "$inc=1";
	});
});
</script>

</head>

<body>
<div class="container">
<h1>게 시 판3 리 스 트</h1>
<table class="table">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자 </th>
			<th>작성일 </th>
			<th>조회수 </th>
		</tr>
	</thead>
	
	<tbody>
		<!-- 데이터가 있는만큼 반복이 되어지는 시작 부분 -->
			<c:forEach items="${list }" var="vo">
		<tr class="dataRow">
			<td class="no">${vo.no }</td>
			<td>${vo.title }</td>
			<td>${vo.writer }</td>
			<td>${vo.writeDate }</td>
			<td>${vo.hit }</td>
		</tr>
		<!-- 데이터가 있는만큼 반복이 되어지는 끝 부분 -->
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