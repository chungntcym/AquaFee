<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,dao.*,model.*"%>

    <%
    String username = (String)request.getParameter("username");
    String password = (String)request.getParameter("password");
    Employee nv = new Employee();
    nv.setUsername(username);
    nv.setPassword(password);
 
    EmployeeDAO dao = new EmployeeDAO();
    boolean kq = dao.checkSignin(nv);
     
    if(kq && (nv.getPosition().equalsIgnoreCase("quan_ly"))){
        session.setAttribute("quan_ly", nv);
        response.sendRedirect("ql/gdChinhNVQuanly.jsp");
    }else if(kq &&(nv.getPosition().equalsIgnoreCase("nhan_vien"))){
        session.setAttribute("thu_thu", nv);
        response.sendRedirect("nv/gdChinhNVThuthu.jsp");
    }else{
        response.sendRedirect("gdDangnhap.jsp?err=fail");
    }
%>
