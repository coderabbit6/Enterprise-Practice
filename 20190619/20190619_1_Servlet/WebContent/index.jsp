<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="http://localhost:8080/20190619_1_Servlet/zujie?admin='张三'">提交注解方式的Servlet</a>
	<br>

	<a href="http://localhost:8080/20190619_1_Servlet/webfun?admin='张三'">WEB
		xml方式Servlet</a>

	<form action="formwebservlet" method="post">

		用户名：<input type="text" name="username"  > <br>
		密码：<input type="text" name="userpwd"  > <br>
		<input type="submit" value="ok">
	</form>

</body>
</html>