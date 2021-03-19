<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, model.*, dao.*"%>
<%ArrayList<TKContract> listyc = new ArrayList<TKContract>();
listyc = (new TKContractDAO()).getAllContract();%>
TKContractDAO tkdao = new TKContractDAO();
listyc = tkdao.getAllContract();%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<title>Thống kê hợp đồng</title>
<%@include file ="../include.jsp" %>
</head>
<body>
<%//@include file ="../include.jsp" %>
</head>
<body>
<h3>Thống kê hợp đồng</h3>
>>>>>>> origin/main
<%if (listyc != null){ %>
<body>
	<table name = "danhsachYeucau">
		<tr>
			<th>T.T</th>
			<th>Họ và tên</th>
			<th>Địa chỉ</th>
			<th>Số điện thoại</th>
			<th>Số CMND/CCCD</th>
			<th>Email</th>
			<th>Loại hợp đồng</th>
		</tr>
		<% for (int i=0; i<listyc.size(); i++) {%>
		<tr>
			<td><%=listyc.get(i).getId() %></td>
			<td><%=listyc.get(i).getFullname() %></td>
			<td><%=listyc.get(i).getAddress()%></td>
			<td><%=listyc.get(i).getPhonenumber() %></td>
			<td><%=listyc.get(i).getIdentityNumber() %></td>
			<td><%=listyc.get(i).getEmail() %></td>
			<td><%=listyc.get(i).getLoaihopdong() %></td>
		</tr>
		<%}} %>
	</table>
	<br>
	<button type="button" name="back" onclick="history.back()">Quay lại</button>
</body>
</html>