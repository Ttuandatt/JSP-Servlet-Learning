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
	String username = (String)session.getAttribute("username");
%>
<h2>Xin chào: <%=username %></h2><hr>

<h2>ĐÂY LÀ TRANG CHÀO MỪNG</h2>
<a href="trang1.jsp">Trang 1</a> | <a href="trang2.jsp">Trang 2</a>
</body>
</html>