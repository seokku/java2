<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 등록 폼</title>

  <!-- BootStrap 라이브러리 등록 : CDN 방식 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>





</head>
<body>
<div class="container">
<h1>공지 등록 폼</h1>
<p>
 공지등록 처리
</p>
<form action="write.jsp" method="post">
	<div class="form-group">
	<!-- 제목 -->
	<label for="title">제목</label>
	<input name="title" class="form-control" id="title" required="required"
	placeholder="3 글자이상 제목입력">
	</div>
	<div class="form-group">
	<!-- 내용 -->
	<label for="content">내용</label>
	<textarea rows="7" name="content" class="form-control" id="content" 
	required="required"></textarea>
	</div>
	<div class="form-group">
	<!-- 공지시작일 -->
	<label for="startDate">공지시작일</label>
	<input name="startDate" class="form-control" id="startDate" required="required"
	placeholder="3 글자이상 제목입력">
	</div>
	<div class="form-group">
	<!-- 공지종료일-->
	<label for="endDate">공지종료일</label>
	<input name="endDate" class="form-control" id="endDate" required="required"
	placeholder="3 글자이상 제목입력">
	</div>

	<button class="btn btn-default">등록</button>
	<button type="button" onclick="history.back()" class="btn btn-default">취소</button>
	</form>
</div>
</body>
</html>