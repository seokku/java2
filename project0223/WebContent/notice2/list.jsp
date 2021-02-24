<%@page import="com.webjjang.notice2.vo.NoticeVO"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// 여기가 자바 코드입니다. JSP ~> Service ~> DAO
String url = request.getServletPath();
@SuppressWarnings("unchecked")
List<NoticeVO> list = (List<NoticeVO>)ExeService.execute(Beans.get(url), null);
// 서버객체 request에 담는다.
request.setAttribute("list", list);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 리스트</title>

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

// 객체 선택에 문제가 있다. 아래 Document가 다 로딩이 되면 실행 되는 스크립트 작성
// jquery -> $(function(){처리문 만들기;}) = jquery(function(){처리문 만들기;})
$(function(){ // jquery에서 익명함수를 전달해서 저장해놨다가 Document가 로딩이 다 되면 호출해서 처리해준다.
	// 데이터 한 줄 선택하기와 이벤트 처리
	$(".dataRow").click(function(){
		// alert($(this));
		// $(this) : 이벤트가 일어난(현재 처리 되고 있는 객체) 자신을 의미
		// .find(selector) : .앞에 객체 안에서 선택한 것을 찾아라
		// .text() : 객체(태그) 사이에 문자를 가져온다.
		// .text(data) : 객체(태그) 사이에 문자를 세팅한다.
		var no = $(this).find(".no").text();
		// 조회수 1증가를 위해 inc=1을 넣는다.
		location = "view.jsp?no=" + no;
	});
});
</script>
</head>
<body>
<div class="container">
<h1>공지사항</h1>
<table class="table">
	<!-- 제목 -->
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>공지시작일</th>
			<th>공지종료일</th>
			<th>작성일</th>
			<th>최종수정일</th>
		</tr>
	</thead>
	<tbody>
		<!-- 데이터가 있는 만큼 반복이 되어 지는 시작 부분 -->
		<c:forEach items="${list }" var="vo">
		<tr class="dataRow">
			<td class="no">${vo.no }</td>
			<td>${vo.title }</td>
			<td>${vo.startDate }</td>
			<td>${vo.endDate }</td>
			<td>${vo.writeDate }</td>
			<td>${vo.updateDate }</td>
		</tr>
		</c:forEach>
		<!-- 데이터가 있는 만큼 반복이 되어 지는 끝 부분 -->
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">
				<a href="writeForm.jsp" class="btn btn-default">글쓰기</a>
			</td>
		</tr>
	</tfoot>
</table>
</div>
</body>
</html>