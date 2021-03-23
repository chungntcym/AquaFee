<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>

<jsp:include page="../include.jsp" />
	<!--Custom styles-->
	<style type="text/css">
    <%@include file="../vendor/css/login.css" %>
</style>
<title>Sign in</title>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3 class="text-center">Đăng nhập</h3>
				</div>
				<div class="card-body">
					<form action="doDangnhap.jsp" method="POST">
						<!-- Username -->
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" class="form-control" placeholder="Tài khoản"
								name="username">
						</div>

						<!-- Password -->
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" class="form-control"
								placeholder="Mật khẩu" name="password">
						</div>

						<div class="form-group">
							<input type="submit" value="Login"
								class="btn float-right login_btn">
						</div>

					</form>
				</div>
				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						Chưa có tài khoản?<a href="./GDDangki.jsp">Đăng kí</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>