<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기 폼</title>

<!-- Bootstrap 라이브러리 등록 - CDN방식 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- fomUtil.js 등록 -->
<script type="text/javascript" src="../js/formUtil.js"></script>

<style type="text/css">
.dataRow:hover{
	cursor: pointer;
	background: #eee;
}
</style>


<script type="text/javascript">
$(function(){
	$("#cancleBtn").click(function(){
		history.back();
	});
});
</script>
</head>
<body>

<div class="container">
<form action="write.jsp" method="post" id="writeForm">
<h1>게시판 글쓰기 폼</h1>
	<!-- 제목 -->
	<div class="form-group">
	<label for="title">제목</label>
	<input name="title" class="form-control" id="title" required="required" placeholder="제목을 입력해주세요.">
	</div>
	
	<!-- 내용 -->
	<div class="form-group">
	<label for="content">내용</label>
	<textarea rows="7" class="form-control" name="content" 
	id="content" required="required" placeholder="내용을 입력해주세요.">내용</textarea>
	</div>
	
	<!-- 작성자 -->
	<div class="form-group">
	<label for="writer">작성자</label>
	<input name="writer" class="form-control" id="writer" required="required" placeholder="작성자를 입력해주세요.">
	</div>
	
	<!-- 버튼 -->
	<!-- 등록 -->
	<button class="btn btn-default">등록</button>
	
	<!-- 다시 입력 -->
	<button type="reset" class="btn btn-default">다시 입력</button>
	
	<!-- 취소 -->
	<button type="button" class="btn btn-default" id="cancleBtn">취소</button>
</form>

</div>

</body>
</html>