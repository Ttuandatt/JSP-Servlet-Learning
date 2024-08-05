<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String hoVaTen = request.getParameter("hoVaTen");
	String email = request.getParameter("email");
	String soLuong = request.getParameter("soLuong");
	int soLuongInt = 0;
	try {
		soLuongInt = Integer.parseInt(soLuong);
	} catch (Exception e) {
	
	}
	%>

	<h1>Xác nhận đặt hàng</h1>
	<br>
	<p>
		Cảm ơn <b><%=hoVaTen%></b> đã đặt <b><%=soLuongInt%></b> sản phẩm.
		Bạn cần thanh toán <b>$<%=soLuongInt*5%>.</b>
	</p>
	<br>
	<p>
		Mọi thông tin sẽ được liên lạc qua email <b><%=email%></b>
	</p>
</body>
</html>