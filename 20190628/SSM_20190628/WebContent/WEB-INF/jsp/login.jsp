<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="<%=basePath%>dologin.html" method="post">
	<div>${error}</div>
		用户名：<input type="text" name="userCode" placeholder="请输入用户名"> <br>
		<br> 密码：<input type="password" name="userPassword"
			placeholder="请输入密码"> <input type="submit" value="确定">


	</form>
</body>
</html>