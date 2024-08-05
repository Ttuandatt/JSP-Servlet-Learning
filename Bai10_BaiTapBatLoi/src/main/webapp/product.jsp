<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		.rq{
			color: red;
		}
	</style>
	
	<script>
	function my_submit() {	
		//Các biến error, maSanPham, tenSanPham, giaNhap, và giaBan được khai báo bằng let để đảm bảo chúng có phạm vi chỉ trong hàm my_submit, tránh xung đột với các biến khác có cùng tên ở phạm vi toàn cục hoặc các hàm khác.
		// Bắt lỗi
		let error = "";
		let maSanPham = document.getElementById("maSanPham").value;
		let tenSanPham = document.getElementById("tenSanPham").value;
		let giaNhap = document.getElementById("giaNhap").value;
		let giaBan = document.getElementById("giaBan").value;

		if (maSanPham.length == 0) {
			error = "Bạn phải nhập mã sản phẩm";
		}
		else if (tenSanPham.length == 0) {
			error = "Bạn phải nhập tên sản phẩm";
		}
		else if (giaNhap <= 0) {
			let error_giaNhap = document.getElementById("error_giaNhap");
			error_giaNhap.innerHTML = "<span class='rq'>Giá nhập phải lớn hơn 0*</span>";
		}
		else if (giaBan <= 0) {
			let error_giaBan = document.getElementById("error_giaBan");
			error_giaBan.innerHTML = "<span class='rq'>Giá bán phải lớn hơn 0*</span>";
		}
		if (error.length > 0) {
			alert(error);
			return;
		} else {
			// Submit
			let my_form = document.getElementById("my_form");
			my_form.submit();
		}
	}
</script>
</head>
<body>
<%
	String e_maSanPham = request.getAttribute("e_maSanPham")+"";
	e_maSanPham = (e_maSanPham.equals("null"))?"":e_maSanPham;

	String e_tenSanPham = request.getAttribute("e_tenSanPham")+"";
	e_tenSanPham = (e_tenSanPham.equals("null"))?"":e_tenSanPham;

	String e_giaNhap = request.getAttribute("e_giaNhap")+"";
	e_giaNhap = (e_giaNhap.equals("null"))?"":e_giaNhap;

	String e_giaBan = request.getAttribute("e_giaBan")+"";
	e_giaBan = (e_giaBan.equals("null"))?"":e_giaBan;

	String value_maSanPham = request.getAttribute("value_maSanPham")+"";
	String value_tenSanPham = request.getAttribute("value_tenSanPham")+"";
	String value_giaBan = request.getAttribute("value_giaBan")+"";
	String value_giaNhap = request.getAttribute("value_giaNhap")+"";
	String value_hanSuDung = request.getAttribute("value_hanSuDung")+"";
	String value_vat = request.getAttribute("value_vat")+"";
	String value_moTa = request.getAttribute("value_moTa")+"";

	value_maSanPham= (value_maSanPham.equals("null"))?"":value_maSanPham;
	value_tenSanPham=(value_tenSanPham.equals("null"))?"":value_tenSanPham;
	value_giaBan= (value_giaBan.equals("null"))?"":value_giaBan;
	value_giaNhap= (value_giaNhap.equals("null"))?"":value_giaNhap;
	value_hanSuDung= (value_hanSuDung.equals("null"))?"":value_hanSuDung;
	value_vat= (value_vat.equals("null"))?"":value_vat;
	value_moTa= (value_moTa.equals("null"))?"":value_moTa;
%>
	<div class="container mt-5">
		<form class="row g-3 needs-validation" action="save-product" id="my_form" method="post">
			<div class="row">
				<div class="col-6">
					<label for="maSanPham" class="form-label">Mã sản phẩm<span class="rq">*</span></label>
					<input type="text" class="form-control" id="maSanPham" name="maSanPham" value="<%=value_maSanPham %>" required>
					<div class="rq"><%=e_maSanPham%></div>
				</div>
				<div class="col-6">
					<label for="tenSanPham" class="form-label">Tên sản phẩm<span class="rq">*</span></label>
					<input type="text" class="form-control" id="tenSanPham" name="tenSanPham" value="<%=value_tenSanPham %>" required>
					<div class="rq"><%=e_tenSanPham%></div>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<label for="giaNhap" class="form-label">Giá nhập<span class="rq">*</span></label>
					<input type="number" step="0.01" class="form-control" id="giaNhap" name="giaNhap" value="<%=value_giaNhap %>" required>
					<div class="rq" id="error_giaNhap"><%=e_giaNhap%></div>
				</div>
				<div class="col-6">
					<label for="giaBan" class="form-label">Giá bán<span class="rq">*</span></label>
					<input type="number" step="0.01" class="form-control" id="giaBan" name="giaBan" value="<%=value_giaBan %>" required>
					<div class="rq" id="error_giaBan"><%=e_giaBan%></div>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<label for="hanSuDung" class="form-label">Hạn sử dụng</label>
					<input type="datetime-local" step="0.01" class="form-control" id="hanSuDung" value="<%=value_hanSuDung %>">
				</div>
				<div class="col-6">
					<label for="vat" class="form-label">VAT</label>
					<input type="number" step="0.01" class="form-control" id="vat" name="vat" value="<%=value_vat %>">
				</div>
			</div>
			<div class="row">
					<label for="moTa" class="form-label">Mô tả sản phẩm</label>
					<textarea rows="10" cols="20" class="form-control" id="moTa" name="moTa" ><%=value_moTa %></textarea>
			</div>
			<div class="row">
				<button class="btn btn-primary" type="button" onclick="my_submit()">Lưu sản phẩm</button>
			</div>

		</form>
	</div>
</body>
</html>