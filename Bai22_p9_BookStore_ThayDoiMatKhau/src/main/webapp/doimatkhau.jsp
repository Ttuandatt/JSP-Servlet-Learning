<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	.green{
		color: green;
	}
</style>
<title>Đổi mật khẩu</title>
</head>
<body>
<%
	String thongBao = request.getAttribute("thongBao")+"";
	thongBao = (thongBao.equals("null"))?"":thongBao;
	
	String matKhauHienTai = request.getAttribute("value_matKhauHienTai")+"";
	String matKhauMoi = request.getAttribute("value_matKhauMoi")+"";
	String matKhauMoiNhapLai = request.getAttribute("value_matKhauMoiNhapLai")+"";
	
	matKhauHienTai = (matKhauHienTai.equals("null"))?"":matKhauHienTai;
	matKhauMoi = (matKhauMoi.equals("null"))?"":matKhauMoi;
	matKhauMoiNhapLai = (matKhauMoiNhapLai.equals("null"))?"":matKhauMoiNhapLai;
%>
	<div class="container">
		<div class="text-center">
			<h2>ĐỔI MẬT KHẨU</h2>
		</div>
		<form class="form" id="my_form" action="doi-mat-khau" method="post">
			<div class="row">
				<div>
					<div class="mb-3">
						<label for="matKhauHienTai" class="form-label">Mật khẩu hiện tại<span class="red">*</span></label>
						<input type="text" class="form-control" id="matKhauHienTai" name="matKhauHienTai" value="<%=matKhauHienTai %>" required="required">
					</div>
					<div class="mb-3">
						<label for="matKhauMoi" class="form-label">Mật khẩu mới<span class="red">*</span></label> 
						<input type="password" class="form-control" id="matKhauMoi" name="matKhauMoi" required="required">
					</div>
					<div class="mb-3">
						<label for="matKhauMoiNhapLai" class="form-label">Nhập lại mật khẩu mới<span class="red">*</span></label> 
						<input type="password" class="form-control" id="matKhauMoiNhapLai" name="matKhauMoiNhapLai" onkeyup="kiemTraMatKhau()" required="required"><span class="red" id="msg"></span>
					</div>
					<div class="red"><%=thongBao %></div>
					<hr>
					<input class="btn btn-primary form-control" type="submit" value="Đổi mật khẩu" name="doiMatKhau" id="doiMatKhau"><a href="index.jsp"></a><br>
					
				</div>
			</div>

		</form>
		

	</div>
	
	<script>
		function kiemTraMatKhau(){
			document.getElementById("msg").innerHTML = "";
			matKhau = document.getElementById("matKhauMoi").value;
			nhapLai = document.getElementById("matKhauMoiNhapLaimatKhauMoiNhapLai").value;
			if(matKhau!=nhapLai){
				document.getElementById("msg").innerHTML = "Mật khẩu nhập lại không khớp!";
				return false;
			}else{
				document.getElementById("msg").innerHTML = "";
				return true;
			}
		}
	
	</script>
</body>
</html>