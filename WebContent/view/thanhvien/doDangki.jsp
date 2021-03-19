<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, java.sql.Date, dao.*,model.*"%>

<%
	MemberDAO memberDAO = new MemberDAO();
String username = request.getParameter("username");
String password = request.getParameter("password");
String fullname = request.getParameter("fullname");
Date dateofbirth = Date.valueOf(request.getParameter("dateofbirth"));
String email = request.getParameter("email");
String phone = request.getParameter("phone");
String securityid = request.getParameter("securityid");
String address = request.getParameter("address");
String gender = request.getParameter("gender");
Member member = new Member(username, password, fullname, dateofbirth, email, phone, securityid, address, gender,
		"reader");
session.setAttribute("member", member);
boolean result = memberDAO.checkSignup(member);
if (result == true) {
	response.sendRedirect("gdDangnhap.jsp?message=good");
} else {
	response.sendRedirect("gdDangki.jsp?message=dup");
}
System.out.println(result);
%>