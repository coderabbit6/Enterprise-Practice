<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");

		boolean valid = false;
		if ("admin".equals(username) && "admin".equals(userpwd)) {
			//创建Session，将用户名保存到Session对象中
			session.setAttribute("loginuser", username);
			//设定失效时间
			session.setMaxInactiveInterval(20);
			valid = true;
		}
		if (valid) {
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	%>
</body>
</html>