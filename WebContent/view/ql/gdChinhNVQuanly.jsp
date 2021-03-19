<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file ="../include.jsp" %>
<title>Trang chủ nhân viên quản lý</title>
</head>
<h3>Nhân viên quản lý</h3>
<body>
<%
//Employee nv = (Employee)session.getAttribute("quan_ly");
//      if(nv==null){
//          response.sendRedirect("doDangnhap.jsp?err=timeout");
//      }
      %>
<button onclick="openPage('gdThongKeHopDong.jsp')">Xem thống kê hợp đồng</button>
<button onclick="openPage('gdThongKeCacLuotNopTien.jsp')">Xem thống kê các lượt nộp tiên của khách hàng</button>
<button onclick="openPage('gdBieuGiaNuoc.jsp')">Xem biểu giá nước</button>
<button onclick="openPage('gdThongKeKhachHangConNo.jsp')">Xem thống kê khách hàng còn nợ</button>
</body>
</html>