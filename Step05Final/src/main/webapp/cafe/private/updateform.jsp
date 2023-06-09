<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/cafe/private/updateform.jsp</title>
</head>
<body>
	<div class="container">
		<h1>글 업데이트 폼</h1>
		<form action="update.jsp" method="post">
			<div>
				<label for="title">제목</label>
				<input type="text" name="title" id="title"/>
			</div>
			<div>
				<label for="content">내용</label>
				<input type="text" name="content" id="content"/>
			</div>
			<button type="submit">저장</button>
		</form>
	</div>
</body>
</html>

