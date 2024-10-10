	<%@page import="database.KhachHangDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
		<%@ page import="model.KhachHang" %>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">	<!-- Có cái này để hiển thị phù hợp được cho chế độ điện thoại -->
	<title>Thay đổi thông tin</title>
	<!-- Đính kèm thư viện Bootstrap  -->
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
		crossorigin="anonymous">
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>
		
	<style>
		.red{
			color: red;
		}
	</style>
	</head>
	<body>
	<%
		// Các thông tin được lấy từ đối tượng khachHang
		// Đối tượng khacHang được lấy từ session which was set since the user logged in successfully
		String hoTen = "";
	    String sdt = "";
	    String email = "";
	    String diaChiNhanHang = "";
	    String gioiTinh = "";
	    KhachHang kh = (KhachHang) session.getAttribute("khachHang"); // Lấy đối tượng KhachHang từ session
	    if (kh != null) {
	        hoTen = kh.getTenKH(); 
	        sdt = kh.getSdt();
	        email = kh.getEmail();
	        diaChiNhanHang = kh.getDiaChiNhanHang();
	        gioiTinh = kh.getGioiTinh();
	        
	    } else {
	        // Xử lý khi session không có KhachHang (có thể redirect về trang đăng nhập)
	        response.sendRedirect("dangnhap.jsp");
	    }
	%>
		<div class="container">
			<div class="text-center">
				<h2>THAY ĐỔI THÔNG TIN</h2>
			</div>
			<form class="form" id="my_form" action="dang-ky" method="post">
				<div class="row">
					<div class="col-sm-6">
						<h3>Thông tin khách hàng</h3>
						<div class="mb-3">
							<label for="hoTen" class="form-label">Họ và tên<span class="red">*</span></label> 
							<input type="text" class="form-control" id="hoTen" name="hoTen" value="<%=hoTen%>" required="required">
							<div class="red"></div>
						</div>
						<div class="mb-3">
							<label for="gioiTinh" class="form-label">Giới tính</label> 
							<select class="form-select" id="gioiTinh" value="" name="gioiTinh">
								<option value="" disabled selected>Chọn giới tính</option>
								<option value="Nam">Nam</option>
								<option value="Nữ">Nữ</option>
								<option value="Khác">Khác</option>
							</select>
						</div>
						<div class="mb-3">
							<label for="ngaySinh" class="form-label">Ngày sinh</label> 
							<input type="date" class="form-control" id="ngaySinh" name="ngaySinh" value="">
						</div>
						<div class="mb-3">
							<label for="diaChi" class="form-label">Địa chỉ nhận hàng<span class="red">*</span></label> 
							<input type="text" class="form-control" id="diaChi" name="diaChi" value="<%=diaChiNhanHang%>" required="required">
							<div class="red"></div>
						</div>
					</div>
	
					<div class="col-sm-6">
					<h3>Thông tin liên lạc</h3>
						<div class="mb-3">
							<label for="email" class="form-label">Email<span class="red">*</span></label> 
							<input type="text" class="form-control" id="email" name="email" value="<%=email %>" required="required">
							<div class="red"></div>
						</div>
						<div class="mb-3">
							<label for="sdt" class="form-label">Số điện thoại<span class="red">*</span></label> 
							<input type="text" class="form-control" id="sdt" name="sdt" value="<%=sdt %>" required="required">
							<div class="red"></div>
						</div>
						<input class="btn btn-primary form-control" type="submit" value="Xác nhận" name="submit2" id="submit2" />
					</div>
				</div>
	
			</form>
	</body>
	</html>