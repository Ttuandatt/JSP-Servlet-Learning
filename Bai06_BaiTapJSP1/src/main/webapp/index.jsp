<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.lang.Math"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bài tập JSP 1</title>
</head>
<body>
	<%
	int a = 3;
	int b = 2;
	int sum = a + b;

	double canBacHai = Math.sqrt(sum);
	%>
	<p>
		3 + 2 =<%=sum%>
	</p>
	<br>
	<p>
		Căn bậc hai của 3 + 2 =
		<%=canBacHai%>
	</p>
</body>
</html>