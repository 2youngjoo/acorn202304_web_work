<%@page import="test.guest.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	int num=Integer.parseInt(request.getParameter("num"));
	String pwd=request.getParameter("pwd");
	GuestDao dao=GuestDao.getInstance();
	dao.delete(num, pwd);
	
	
	// context 경로 얻어내기 (context 경로는 추후에 수정되거나 제거될 예정이기 때문에 메소드로 얻어낸다)
	String cPath=request.getContextPath();
	
	// 리다일렉트 응답하기
	response.sendRedirect(cPath+"/guest/list.jsp");
%>
