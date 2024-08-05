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
	String email = request.getParameter("email");
%>
	<h2>Mua hàng thành công, thông tin đơn hàng sẽ được cập nhật qua email <%=email %></h2>
</body>
</html>