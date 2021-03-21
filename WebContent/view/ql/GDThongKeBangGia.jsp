<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.text.*, model.*, dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thống kê lịch sử giá nước</title>
<%@include file ="../include.jsp" %>
<link rel="stylesheet" href="../vendor/css/main_view.css">
</head>
<body>
<% 
	String date = request.getParameter("id").toString();
	if (date != null) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = format.parse(date);
		Date year = new Date(d.getTime());
		TKGradeDAO dao = new TKGradeDAO();
		ArrayList<TKGrade> list = new ArrayList<TKGrade>();
		list = dao.getGradeByyear(year);
		System.out.print(list);%>
			

<div class="d-flex" id="wrapper">

		<%@include file="menu.jsp"%>

		<!-- Page Content -->
		<div id="page-content-wrapper">

			<%@include file="navbar.jsp"%>

			<div class="container-fluid">
				<!-- Code in here -->
				<%if (list.size() != 0){ %>
				<div class="card mt-3">
					<div class="card-header d-flex justify-content-between">
						<div class="my-auto">
							Bảng giá nước năm
							<%Calendar cal = Calendar.getInstance();
							cal.setTime(year); %>
							<%=cal.get(Calendar.YEAR)%></div>
					</div>
					<div class="card-body">
						<form>
						<table class="table">
								<thead>
									<tr>
										<th>Bậc</th>
										<th>Hạn mức (m3/người)</th>
										<th>Giá (đồng)</th>
										<th>Ngày bắt đầu</th>
										<th>Loại hợp đồng</th>
									</tr>
								</thead>
								<tbody>
									<%
									for (TKGrade grade : list) {
									%>
									<tr>
										<td><%=grade.getGrade()%></td>
										<td><%=grade.getValue()%></td>
										<td><%=grade.getPrice()%></td>
										<td>
										<%SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
										String startDate = format1.format(grade.getStartDate());%>
										<%=startDate%></td>
										<td><%=grade.getLoaihopdong()%></td>
									</tr>
									<%
									}
			}else {%>
				<h3>Năm đã chọn chưa cấu hình bảng giá</h3>
			<%}
		}
									%>
								</tbody>
							</table>
							<div class="card-footer d-flex justify-content-end">
								<button class="btn btn-outline-secondary px-4" type="button" name="back" onclick="history.back()">Quay lại</button>
							</div>
						</form>
					</div>
				</div>
	<br>
</body>
</html>