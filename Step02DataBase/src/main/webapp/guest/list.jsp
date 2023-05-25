<%@page import="test.guest.dto.GuestDto"%>
<%@page import="java.util.List"%>
<%@page import="test.guest.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//GuestDao 객체의 참조 값 얻어오기
	GuestDao dao=GuestDao.getInstance();
	// 회원 목록 얻어오기
	List<GuestDto> list=dao.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/board_guest/list.jsp</title>
<style>
	h1{
	text-align: center;
	background-color: yellow;
	}
	tr{
	text-align: center;
	}
	th{
	text-align: center;
	}
	td{
	text-align: center;
	}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>방명록 목록</h1>
		<div style="text-align:right">			
			<a href="insertform.jsp">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-plus" viewBox="0 0 16 16">
  				  	<path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H1s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C9.516 10.68 8.289 10 6 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
                  	<path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
				</svg>
				<span class="visually-hidden">방명록 추가</span>
			</a>
		</div>
		<table class="table table-bordered border-primary">
			<thead>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>내용</th>
					<th>작성일</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<% for(GuestDto tmp:list) {%>
				<tr>
					<td><%= tmp.getNum() %></td>
					<td><%= tmp.getWriter() %></td>
					<td><%= tmp.getContent() %></td>
					<td><%= tmp.getDate() %></td>
					<td>
						<a href="updateform.jsp?num=<%= tmp.getNum() %>">수정</a>
					</td>
					<td>
						<form action="delete.jsp?num=<%=tmp.getNum() %> "method="post">
							<input type="text" name="pwd" id="pwd"/>
								<span class="visually-hidden">삭제</span>
								<button type="submit">삭제</button>
						</form>
		
					</td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	<script src=https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js></script>	
</body>
</html>

