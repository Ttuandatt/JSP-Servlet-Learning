<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: yellow;">
<%
	String username = (String)session.getAttribute("username");
%>
<h2>Xin chào <%=username %></h2><hr>
<h2>ĐÂY LÀ TRANG 1</h2>
<a href="success.jsp">Trang chào mừng</a>
</body>
</html>