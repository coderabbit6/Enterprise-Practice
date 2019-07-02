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

	不同方式的参数提交。。
	<br>
	<br> 表单提交。
	<br>
	<a href="<%=basePath%>jsp/add.jsp">通过表单方式传递参数</a>
	<br> URL超链接提交。
	<br>
	<br>
	<a href="<%=basePath%>welcome?username=admin&age=20">通过超链接方式传递参数</a>
</body>
</html>