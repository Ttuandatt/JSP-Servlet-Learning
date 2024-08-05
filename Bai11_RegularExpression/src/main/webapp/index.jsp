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
			error = "";
			soLuong = document.getElementById("soLuong").value;
			sdt = document.getElementById("sdt").value;
			email = document.getElementById("email").value;
			
			if(soLuong.length == 0){
				error = "Vui lòng nhập số lượng!";
			}
			else if(sdt.length == 0){
				error = "Vui lòng nhập số điện thoại!";
			}
			else if(email.length == 0){
				error = "Vui lòng nhập email!";
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
		<!-- Sau khi code script JS xong ở các component phải có từ khóa required mới có thể thực thi điều kiện JS một cách chính xác -->
	</script>
</head>
<body>
<%
	String e_soLuong = request.getAttribute("e_soLuong")+""; //+"": ép kiểu về String, có thể ghi lại theo cách (String)request.getAttribute("e_soLuong")
	e_soLuong = (e_soLuong.equals("null"))?"":e_soLuong;	//e_soLuong có bằng null không. Nếu có thì e_soLuong = "", không thì hiển thị chuỗi được set ở bên servlet
	String e_sdt = request.getAttribute("e_sdt") + "";
	e_sdt = (e_sdt.equals("null"))?"":e_sdt;
	String e_email = request.getAttribute("e_email")+"";
	e_email = (e_email.equals("null"))?"":e_email;
	
	String value_soLuong = request.getAttribute("value_soLuong")+"";
	String value_sdt = request.getAttribute("value_sdt")+"";
	String value_email = request.getAttribute("value_email")+"";
	
	value_soLuong = (value_soLuong.equals("null"))?"":value_soLuong;
	value_sdt = (value_sdt.equals("null"))?"":value_sdt;
	value_email = (value_email.equals("null"))?"":value_email;
%>
	<div class="container mt-5">
		<form action="mua-hang" method="get" id="my_form">
			Số lượng đặt mua: <input class="form-control" type="text" id="soLuong" name="soLuong" value="<%=value_soLuong %>" required><span class="rq"><%=e_soLuong %></span><br>
			SDT: <input class="form-control" type="text" id="sdt" name="sdt" value="<%=value_sdt%>" required><span class="rq"><%=e_sdt %></span><br>
			Email: <input class="form-control" type="text" id="email" name="email" value="<%=value_email %>" required><span class="rq" ><%=e_email %></span><br>
			<input class="form-control" type="submit" value="Mua hàng" onclick="my_submit()">
		</form>
	</div>
</body>
</html>