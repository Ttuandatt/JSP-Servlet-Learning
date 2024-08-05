<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.error{
		color: red;
	}
</style>
<script>
	function my_submit() {
		error = "";
		username = document.getElementById("username").value;
		password = document.getElementById("password").value;
		
		if(username.length == 0){
			error = "Vui lòng nhập username";
		}
		else if(password.length == 0){
			error = "Vui lòng nhập password";
		}
		
		if(error.length>0){
			alert(error);
			return;
		}else{
			my_form = document.getElementById("my_form");
			my_form.submit();
		}
	}
</script>
</head>
<body>
<%
	String e_username = request.getAttribute("e_username")+"";
	e_username = (e_username.equals("null"))?"":e_username;
	
	String e_password = request.getAttribute("e_password")+"";
	e_password = (e_password.equals("null"))?"":e_password;
	
	String value_username = request.getAttribute("value_username")+"";
	String value_password = request.getAttribute("value_password")+"";
	
	value_username = (value_username.equals("null"))?"":value_username;
	value_password = (value_password.equals("null"))?"":value_password;
%>
<div class="container mt-5">
	<h2>LOGIN</h2>
	<form class="row g-3 needs-validation" action="login" method="get" id="my_form">
		<div class="col-6">
			<label for="username" class="form-label">Username</label>
			<input type="text" class="form-control" id="username" name="username" value="<%=value_username%>" required>
			<div class="error"><%=e_username %></div>
		</div><br>
		<div class="col-6">
			<label for="password" class="form-label">Password</label>
			<input type="password" class="form-control" id="password" name="password" value="<%=value_password %>" required>
			<div class="error"><%=e_password %></div>
		</div><br>
		
		<div>
			<input type="button" onclick="my_submit()" value="Login">
		</div>
	</form>	
</div>
</body>
</html>