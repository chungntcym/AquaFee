<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList, java.sql.Date, dao.*,model.*"%>

<%
	MemberDAO memberDAO = new MemberDAO();
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	Member member = new Member(username,password);
	Member result = memberDAO.checkSignin(member);
	if(result != null){
		session.setAttribute("member", result);
		//Neu nguoi dang nhap la doc gia
		if(result.getRole().equals("reader")){
			response.sendRedirect("../docgia/gdChinhDocgia.jsp");
		}
		//Neu nguoi dang nhap la nhan vien
		if(result.getRole().equals("employee")){
			String position = memberDAO.getPositionById(result.getId());
			if(position != null){
				if(position.equals("librarian")){
					//Redirect to gdChinhThuthu
					response.sendRedirect("../thuthu/gdChinhThuthu.jsp");
				}
			}
		}
	}
	else{
		//Sai mat khau
		response.sendRedirect("gdDangnhap.jsp?message=wrongPass");
	}
%>