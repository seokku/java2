<%@page import="com.webjjang.notice2.vo.NoticeVO"%>
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

NoticeVO vo = (NoticeVO)ExeService.execute(Beans.get(url),no);
// 서버객체 request에 담는다.
request.setAttribute("vo", vo);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 보기</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">

// 객체 선택에 문제가 있다. 아래 Document가 다 로딩이 되면 실행 되는 스크립트 작성
// jquery -> $(function(){처리문 만들기;}) = jquery(function(){처리문 만들기;})
$(function(){ // jquery에서 익명함수를 전달해서 저장해놨다가 Document가 로딩이 다 되면 호출해서 처리해준다.
	// 삭제 버튼을 클릭하면 실제 삭제를 할지 안할지 물어본다.
	$("#deleteBtn").click(function(){
		if(!confirm("정말로 삭제하시겠습니까?")) return false; // a tag의 이동 취소
	});
});
</script>
</head>
<body>
<div class="container">
<h1>게시판 글 보기</h1>
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
			<th>최종 수정일</th>
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