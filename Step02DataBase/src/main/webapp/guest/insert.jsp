<%@page import="test.guest.dao.GuestDao"%>
<%@page import="test.guest.dto.GuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. post 방식으로 전송되는 방명록 내용을 추출한다.
	request.setCharacterEncoding("utf-8");
	String writer=request.getParameter("writer");
	String content=request.getParameter("content");
	String pwd=request.getParameter("pwd");
	

	// 추가할 회원 방명록 정보를 GuestDto 객체에 담는다.
	GuestDto dto=new GuestDto();
	dto.setWriter(writer);
	dto.setContent(content);
	dto.setPwd(pwd);

	// 2. DB에 저장한다.
	GuestDao dao=GuestDao.getInstance();
	boolean isSuccess=dao.insert(dto); // 작업의 성공 여부가 리턴된다.

	// 3. 응답한다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/guest/insert.jsp</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
</head>
<body>
	<!-- 이 주석은 웹 브라우저에게 출력되지만 웹 브라우저가 무시하는 주석 -->
	<%-- 이 주석은 jsp 페이지가 무시하는 주석(웹 브라우저에 출력되지 않는다 --%>
	<%-- javascript 응답하기 --%>
	<div class="container mt-5">
		<h1>알림</h1>
		<%if(isSuccess){ %>			
			<p class="alert alert-success">
				<strong><%=writer %></strong> 님의 방명록이 저장 되었습니다.
				<a class="alert-link" href="list.jsp">확인</a>
			</p>
		<%}else{ %>
			<p class="alert alert-danger">
				방명록 저장 실패!
				<a class="alert-link" href="inserform.jsp">다시 작성</a>
			</p>
		<%} %>
	</div>
	<script>
		<%if(isSuccess){ %>
			// 알림창 띄우기
			alert("글을 성공적으로 등록 했습니다!")
			// javascript로 페이지 이동
			location.href="${pageContext.request.contextPath }/guest/list.jsp";
		<%}else{ %>
			alert("등록 실패!")
			location.href="${pageContext.request.contextPath }/guest/insertform.jsp";
		<%} %>		
	</script>
</body>
</html>

