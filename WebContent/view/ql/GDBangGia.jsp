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
<title>Library - Reader</title>
<%
int id = Integer.parseInt(request.getParameter("id"));
ContractType contractType = new ContractType();
ArrayList<ContractType> listContractTypes = (ArrayList<ContractType>) session.getAttribute("listContractType");
for (ContractType ct : listContractTypes) {
	if (id == ct.getId()) {
		contractType = ct;
		break;
	}
}
GradeDAO gradeDAO = new GradeDAO();
ArrayList<Grade> listGrade = gradeDAO.getTableGradeByContractTypeId(String.valueOf(id));
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
						<div class="my-auto">
							Bảng giá cho
							<%=contractType.getType()%></div>
					</div>
					<div class="card-body">
						<form>
							<table class="table">
								<thead>
									<tr>
										<th scope="col">Bậc</th>
										<th scope="col">Ngưỡng</th>
										<th scope="col">Giá</th>
										<th scope="col">Hành động</th>
									</tr>
								</thead>
								<tbody>
									<%
									for (Grade grade : listGrade) {
									%>
									<tr>
										<td>
											<div class="form-group">
												<input type="text" class="form-control"
													value=<%=grade.getGrade()%>>
											</div>
										</td>
										<td>
											<div class="form-group">
												<input type="text" class="form-control"
													value=<%=grade.getValue()%>>
											</div>
										</td>
										<td>
											<div class="form-group">
												<input type="text" class="form-control"
													value=<%=grade.getPrice()%>>
											</div>
										</td>
									</tr>
									<%
									}
									%>
								</tbody>
							</table>
						</form>
					</div>
				</div>

			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->
	<script type="text/javascript">
		$(function() {
			$('#contract-type-select').bind('change', function() {
				var url = $(this).val(); // get selected value
				alert(url); // This will help to check whether JS is getting executed.
				if (url) { // require a URL
					window.location = url; // redirect
				}
				return false;
			});
		});
	</script>
</body>
</html>