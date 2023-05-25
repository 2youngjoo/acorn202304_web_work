<%@page import="test.guest.dto.GuestDto"%>
<%@page import="test.guest.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 수정할 방명록 번호를 얻어낸다.
	int num=Integer.parseInt(request.getParameter("num"));
	// 2. 번호를 이용해서 DB에 저장된 수정할 방명록 정보를 얻어낸다.
	GuestDto dto=GuestDao.getInstance().getData(num);
	// 3. 수정할 양식을 클라이언트에게 응답한다.	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/guest/updateform.html</title>
</head>
<body>
	<div class="container">
		<h1>방명록 수정</h1>
		<form action="update.jsp" method="post">
			<div class="mb-1">
				<label class="form-label" for="num">번호</label>
				<input type="text" id="num" name="num" value="<%=dto.getNum()%>"/>
			</div>
			<div class="mb-1">
				<label class="form-label" for="writer">작성자</label>
				<input type="text" id="writer" name="writer" value="<%=dto.getWriter()%>"/>
			</div>
			<div class="mb-1">
				<label class="form-label" for="content">내용</label>
				<textarea name="content" id="content" cols="15" rows="5"><%=dto.getContent() %></textarea>
			</div>
			<button class="btn btn-outline-primary" type="submit">수정 확인</button>
			<button class="btn btn-outline-warning" type="reset">취소</button>
		</form>
	</div>	
</body>
</html>

