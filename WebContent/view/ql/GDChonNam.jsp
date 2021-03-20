<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="java.util.ArrayList, dao.*, model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

<head>
<meta charset="UTF-8">
<jsp:include page="../include.jsp" />
<!--Custom styles-->
<link rel="stylesheet" href="../vendor/css/main_view.css">
<title>Chọn năm</title>
<%
	ContractTypeDAO contractTypeDAO = new ContractTypeDAO();
	ArrayList<ContractType> listContractTypes = contractTypeDAO.getAllContractType();
	session.setAttribute("listContractType", listContractTypes);
%>
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
						<div class="my-auto">Xem thống kê bảng giá nước</div>
					</div>
					<div class="card-body">
						<table>
						    <tr>
						        <td>
						            <input type="date" id="date-input" name="date-input">
						            <button onclick= "myFunction()">Xem bảng giá</button>
						        <td>
						    </tr>
						</table>
					</div>
				</div>

			</div>
		</div>
		<!-- /#page-content-wrapper -->
	
	</div>
	<!-- /#wrapper -->
	<script>
	function myFunction() {
		var text = $('#date-input').val();
		if (text){
			window.location = "GDThongKeBangGia.jsp?id=" + text;
		}
	}
	</script>
</body>
</html>