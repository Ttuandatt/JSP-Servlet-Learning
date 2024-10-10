<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">	<!-- Có cái này để hiển thị phù hợp được cho chế độ điện thoại -->
<title>Đăng ký</title>
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
	String e_tenDangNhap = request.getAttribute("e_tenDangNhap")+"";
	e_tenDangNhap = (e_tenDangNhap.equals("null"))?"":e_tenDangNhap;
	String e_matKhau = request.getAttribute("e_matKhau")+"";
	e_matKhau = (e_matKhau.equals("null"))?"":e_matKhau;
	String e_nhapLai = request.getAttribute("e_nhapLai")+"";
	e_nhapLai = (e_nhapLai.equals("null"))?"":e_nhapLai;
	String e_hoTen = request.getAttribute("e_hoTen")+"";
	e_hoTen = (e_hoTen.equals("null"))?"":e_hoTen;
	String e_diaChi = request.getAttribute("e_diaChi")+"";
	e_diaChi = (e_diaChi.equals("null"))?"":e_diaChi;
	String e_email = request.getAttribute("e_email")+"";
	e_email = (e_email.equals("null"))?"":e_email;
	String e_sdt = request.getAttribute("e_sdt")+"";
	e_sdt = (e_sdt.equals("null"))?"":e_sdt;
	
	String value_tenDangNhap = request.getAttribute("value_tenDangNhap")+"";
	value_tenDangNhap = (value_tenDangNhap.equals("null"))?"":value_tenDangNhap;
	String value_hoTen = request.getAttribute("value_hoTen")+"";
	value_hoTen = (value_hoTen.equals("null"))?"":value_hoTen;
	String value_gioiTinh = request.getAttribute("value_gioiTinh")+"";
	value_gioiTinh = (value_gioiTinh.equals("null"))?"":value_gioiTinh;
	String value_ngaySinh = request.getAttribute("value_ngaySinh")+"";
	value_ngaySinh = (value_ngaySinh.equals("null"))?"":value_ngaySinh;
	String value_diaChi = request.getAttribute("value_diaChi")+"";
	value_diaChi = (value_diaChi.equals("null"))?"":value_diaChi;
	String value_email = request.getAttribute("value_email")+"";
	value_email = (value_email.equals("null"))?"":value_email;
	String value_sdt = request.getAttribute("value_sdt")+"";
	value_sdt = (value_sdt.equals("null"))?"":value_sdt;
	
%>
	<div class="container">
		<div class="text-center">
			<h2>ĐĂNG KÝ TÀI KHOẢN</h2>
		</div>
		<form class="form" id="my_form" action="dang-ky" method="post">
			<div class="row">
				<div class="col-sm-6">
					<h3>Tài khoản</h3>
					<div class="mb-3">
						<label for="tenDangNhap" class="form-label">Tên đăng nhập<span class="red">*</span></label>
						<input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap" value="<%=value_tenDangNhap%>"required="required">
						<div class="red"><%=e_tenDangNhap%></div>
					</div>
					<div class="mb-3">
						<label for="matKhau" class="form-label">Mật khẩu<span class="red">*</span></label> 
						<input type="password" class="form-control" id="matKhau" name="matKhau" required="required">
						<div class="red"><%=e_matKhau %></div>
					</div>
					<div class="mb-3">
						<label for="nhapLai" class="form-label">Nhập lại mật khẩu<span class="red">*</span></label> 
						<input type="password" class="form-control" id="nhapLai" name="nhapLai" onkeyup="kiemTraMatKhau()" required="required"><span class="red" id="msg"></span>
					</div>
					<hr>

					<h3>Thông tin khách hàng</h3>
					<div class="mb-3">
						<label for="hoTen" class="form-label">Họ và tên<span class="red">*</span></label> 
						<input type="text" class="form-control" id="hoTen" name="hoTen" value="<%=value_hoTen%>"required="required">
						<div class="red"><%=e_hoTen %></div>
					</div>
					<div class="mb-3">
						<label for="gioiTinh" class="form-label">Giới tính</label> 
						<select class="form-select" id="gioiTinh" value="<%=value_gioiTinh %>" name="gioiTinh">
							<option value="" disabled selected>Chọn giới tính</option>
							<option value="Nam">Nam</option>
							<option value="Nữ">Nữ</option>
							<option value="Khác">Khác</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="ngaySinh" class="form-label">Ngày sinh</label> 
						<input type="date" class="form-control" id="ngaySinh" name="ngaySinh" value="<%=value_ngaySinh%>">
					</div>
					<div class="mb-3">
						<label for="diaChi" class="form-label">Địa chỉ nhận hàng<span class="red">*</span></label> 
						<input type="text" class="form-control" id="diaChi" name="diaChi" value="<%=value_diaChi %>" required="required">
						<div class="red"><%=e_diaChi %></div>
					</div>
				</div>

				<div class="col-sm-6">
				<h3>Thông tin liên lạc</h3>
					<div class="mb-3">
						<label for="email" class="form-label">Email<span class="red">*</span></label> 
						<input type="text" class="form-control" id="email" name="email" value="<%=value_email%>" required="required">
						<div class="red"><%=e_email %></div>
					</div>
					<div class="mb-3">
						<label for="sdt" class="form-label">Số điện thoại<span class="red">*</span></label> 
						<input type="text" class="form-control" id="sdt" name="sdt" value="<%=value_sdt%>" required="required">
						<div class="red"><%=e_sdt %></div>
					</div>
					<div class="mb-3 form-check">
						<label class="form-check-label" for="checkboxdieukhoan"><a href="dieukhoan.jsp">Đồng ý với điều khoản</a><span class="red">*</span></label>
						<input type="checkbox" class="form-check-input" id="checkboxdieukhoan" name="checkboxdieukhoan" required="required" onchange="xuLyChonDongY()">
					</div>
					<input class="btn btn-primary form-control" type="submit" value="Đăng ký" name="submit1" id="submit1" style="visibility: hidden;" />
				</div>
			</div>

		</form>
	</div>
	
	<script>
		function kiemTraMatKhau(){
			document.getElementById("msg").innerHTML = "";
			matKhau = document.getElementById("matKhau").value;
			nhapLai = document.getElementById("nhapLai").value;
			if(matKhau!=nhapLai){
				document.getElementById("msg").innerHTML = "Mật khẩu không khớp!";
				return false;
			}else{
				document.getElementById("msg").innerHTML = "";
				return true;
			}
		}
	
		function xuLyChonDongY(){
			dongYDieuKhoan = document.getElementById("checkboxdieukhoan");
			if(dongYDieuKhoan.checked==true){
				document.getElementById("submit1").style.visibility="visible";
			}else {
				document.getElementById("submit1").style.visibility="hidden";
			}
		}
	</script>
</body>
</html>