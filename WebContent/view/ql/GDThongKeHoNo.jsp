<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, model.*, dao.*"%>
<%
TKPaymentDAO paymentDAO = new TKPaymentDAO();
ResultSet resultSet = paymentDAO.getPaymentStats();
%>
<!DOCTYPE html>
<html lang="vi">

<head>
<meta charset="UTF-8">
<jsp:include page="../include.jsp" />
<!--Custom styles-->
<link rel="stylesheet" href="../vendor/css/main_view.css">
<title>Aquaman - Thống kê hộ nợ</title>
</head>
<body>
	<div class="d-flex" id="wrapper">

		<%@include file="menu.jsp"%>

		<!-- Page Content -->
		<div id="page-content-wrapper">

			<%@include file="navbar.jsp"%>

			<div class="container-fluid">
				<!-- Code in here -->
				<div class="card mt-3">
					<div class="card-header d-flex justify-content-between">
						<span class="navbar-brand mb-0 h1">Thống kê hộ nợ</span>
					</div>
					<div class="card-body">
						<form>
							<table class="table">
								<thead>
									<tr>
										<th>T.T</th>
										<th>Mã khách hàng</th>
										<th>Họ và tên</th>
										<th>Địa chỉ</th>
										<th>Loại hợp đồng</th>
										<th>Chỉ số đồng hồ</th>
										<th>Tiền (đồng)</th>
										<th>Tình trạng</th>
									</tr>
								</thead>
								<tbody>
									<%
									int i = 1;
									while (resultSet.next()) {
									%>
									<tr>
										<td><%=i%></td>
										<td><%=resultSet.getInt("tblCustomerid")%></td>
										<td><%=resultSet.getString("fullname")%></td>
										<td><%=resultSet.getString("address")%></td>
										<td><%=resultSet.getString("type")%></td>
										<td><%=resultSet.getInt("water_meter_value")%></td>
										<td><%=resultSet.getFloat("price")%></td>
										<td><%=resultSet.getTimestamp("payment_time") == null ? "Chưa trả": resultSet.getTimestamp("payment_time")%></td>
									</tr>
									<%
									i++;
									}
									%>
								</tbody>
							</table>
							<div class="card-footer d-flex justify-content-end">
								<button class="btn btn-outline-secondary px-4" type="button"
									name="back" onclick="history.back	()">Quay lại</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>