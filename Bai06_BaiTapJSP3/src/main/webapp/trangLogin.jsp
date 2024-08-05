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
	String email =	request.getParameter("email1");
	String password = request.getParameter("password1");
	%>
	
	<p>Email đã nhập: <b><%=email %></b></p><br>	
	<p>Mật khẩu: <b><%=password %></b></p>
</body>
</html>