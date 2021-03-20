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
<title>Bảng giá</title>
<%
int id = Integer.parseInt(request.getParameter("id"));
session.setAttribute("contractTypeId", id);
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
				<form method="POST" action="doSaveBangGia.jsp">
					<div class="card mt-3">
						<div class="card-header d-flex justify-content-between">
							<div class="my-auto">
								Bảng giá cho
								<%=contractType.getType()%></div>
						</div>
						<div class="card-body">

							<table id="grade-table" class="table">
								<thead>
									<tr>
										<th scope="col" style="width: 15%">Bậc</th>
										<th scope="col" data-toggle="tooltip" data-placement="right"
											title="Là ngưỡng mà khi lượng nước dùng đến giá trị này thì mức giá tương ứng sẽ được áp dụng">
											Ngưỡng <span class="ml-2 my-0"><i
												class="fa fa-info-circle text-info"></i></span>
										</th>
										<th scope="col">Giá</th>
										<th scope="col" class="text-center" style="width: 8.33%">Hành
											động</th>
									</tr>
								</thead>
								<tbody>
									<%
									for (Grade grade : listGrade) {
									%>
									<tr>
										<td>
											<div class="form-group">
												<input type="text" name="grade"
													class="form-control grade-input"
													value=<%=grade.getGrade()%> readonly>
											</div>
										</td>
										<td>
											<div class="form-group">
												<input type="text" name="value" class="form-control value-field"
													value=<%=grade.getValue()%>>
											</div>
										</td>
										<td>
											<div class="form-group">
												<input type="text" name="price" class="form-control"
													value=<%=grade.getPrice()%>>
											</div>
										</td>
										<td class="d-flex justify-content-center">
											<button class="btn btn-outline-danger btnDelete">
												<i class="fa fa-times"></i>
											</button>
										</td>
									</tr>
									<%
									}
									%>
								</tbody>
							</table>
						</div>
						<div class="card-footer d-flex justify-content-end">
							<button class="btn btn-outline-secondary px-4" type="submit">Lưu</button>
						</div>
					</div>
				</form>
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

		$("#grade-table").on('click', '.btnDelete', function() {
			$(this).closest('tr').remove();
			autoNumber();
		});
		
		function autoNumber() {
			$('#grade-table .grade-input').each(function(i) {
				console.log(i);
				$(this).val(i + 1);
			});
		}
		
		

		function sortTable() {
			var table, rows, switching, i, x, y, shouldSwitch;
			table = document.getElementById("grade-table");
			switching = true;
			/* Make a loop that will continue until
			no switching has been done: */
			while (switching) {
				// Start by saying: no switching is done:
				switching = false;
				rows = table.rows;
				/* Loop through all table rows (except the
				first, which contains table headers): */
				for (i = 1; i < (rows.length - 1); i++) {
					// Start by saying there should be no switching:
					shouldSwitch = false;
					/* Get the two elements you want to compare,
					one from current row and one from the next: */
					x = rows[i].getElementsByTagName("TD")[1];
					y = rows[i + 1].getElementsByTagName("TD")[1];
					// Check if the two rows should switch place:
					if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
						// If so, mark as a switch and break the loop:
						shouldSwitch = true;
						break;
					}
				}
				if (shouldSwitch) {
					/* If a switch has been marked, make the switch
					and mark that a switch has been done: */
					rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
					switching = true;
				}
			}
		}
	</script>
</body>
</html>