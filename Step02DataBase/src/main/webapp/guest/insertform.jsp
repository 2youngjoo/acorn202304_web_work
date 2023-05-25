<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/guest_board/insertform.jsp</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
</head>
<body>
		<div class="container">
		<h1>방명록 추가 폼</h1>
		<form action="insert.jsp" method="post">			
       	 	<div class="mb-3">
        		<label for="addr" class="form-lable">번호</label>
        		<input class="form-control" type="text" name="num" id="num">
        	</div>
       	 	<div class="mb-3">
        		<label for="addr" class="form-lable">작성자</label>
        		<input class="form-control" type="text" name="writer" id="writer">
        	</div>
			<div class="mb-3">
				<label for="name" class="form-lable">내용</label>
       	 		<textarea class="form-control" name="content" id="content" cols="30" rows="10"></textarea>
       	 	</div>
       	 	<div class="mb-3">
        		<label for="addr" class="form-lable">비밀번호</label>
        		<input class="form-control" type="text" name="pwd" id="pwd">
        	</div>
        	<button class="btn btn-success"type="submit">추가</button>
		</form>
	</div>
</body>
</html>
