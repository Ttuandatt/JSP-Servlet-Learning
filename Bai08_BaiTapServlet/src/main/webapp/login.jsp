<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<!-- Tạo trang login, nếu user đăng nhập thành công thì chuyển sang trang success.jsp, ngược lại thì chuyển sang trang error.jsp -->
	<form action="dang-nhap" method="POST"> <!-- Vì bài đang là làm về login nên dùng method Post để dấu đi thông tin trên thanh URL -->
		<h2>LOGIN</h2>
		Username: <input type="text" name="username"> <br>
		Password: <input type="password" name="password"> <br> <input
			type="submit" value="Login">
	</form>
</body>
</html>