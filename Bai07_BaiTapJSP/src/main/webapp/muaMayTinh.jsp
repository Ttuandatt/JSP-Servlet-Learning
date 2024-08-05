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
</head>
<body>
	<div class="container">
		<h1>Chọn cấu hình</h1>
		<hr>
		<form action="trangMuaHang.jsp">
			<h2>Processor</h2>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="processor"
					id="corei9" value="COREI9"> <label class="form-check-label"
					for="corei9"> Core I9 </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="processor"
					id="corei7" value="COREI7"> <label class="corei7"
					for="flexRadioDefault2"> Core I7</label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="processor"
					id="corei5" value="COREI5"> <label class="corei5"
					for="flexRadioDefault2"> Core I5</label>
			</div>
			<hr>
			<h2>RAM</h2>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="ram" id="16gb"
					value="16GB"> <label class="16gb" for="flexRadioDefault2">
					16GB</label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="ram" id="8gb"
					value="8GB"> <label class="8gb" for="flexRadioDefault2">
					8GB</label>
			</div>
			<hr>
			<h2>Monitor</h2>
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value="Monitor" id="small" name="monitor">
				<label class="form-check-label" for="small"> Monitor </label>
			</div>
			
			<hr>
			<h2>Accessories</h2>
			<select class="form-select" aria-label="Default select example" name="accessories">
				<option selected>Options</option>
				<option value="Camera">Camera</option>
				<option value="Printer">Printer</option>
				<option value="Scanner">Scanner</option>
			</select>
			<button class="btn btn-primary mt-2" type="submit">Buy</button>	<!-- btn-primary: định màu xanh dương cho button, mt-2: margin top 2px -->
		</form>
	</div>
</body>
</html>