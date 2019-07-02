<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");

		//链接数据库获取用户名密码。进行判断

		if ("admin".equals(username) && "admin".equals(userpwd)) {
			request.getRequestDispatcher("main.jsp").forward(request,response);
		}else{
			response.sendRedirect("error.jsp");
			//http://localhost:8080/20190618_3_jspresponse/error.jsp
			
		}
	%>
</body>
</html>