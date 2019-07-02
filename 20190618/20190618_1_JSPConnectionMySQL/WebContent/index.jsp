<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="Utils.*,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<table width="500" align="center" border="1" cellpadding="0"
		cellspacing="0">

		<tr align="center">
			<td>id</td>
			<td>name</td>
			<td>age</td>
			<td>tel</td>
			<td>address</td>
		</tr>

	

	<%
		ResultSet rs = ConnectionMySQL.getResult();
		String name = null;
		int age = 0;
		int tel = 0;
		String address = null;
		int id = 0;
		while (rs.next()) {
			id = rs.getInt(1);
			name = rs.getString("name");
			age = rs.getInt(3);
			tel = rs.getInt("tel");
			address = rs.getString("address");
	%>
	<tr align="center">
		<td>
			<%
				out.print(id);
			%>
		</td>
		<td>
			<%
				out.print(name);
			%>
		</td>
		<td>
			<%
				out.print(age);
			%>
		</td>
		<td>
			<%
				out.print(tel);
			%>
		</td>
		<td>
			<%
				out.print(address);
			%>
		</td>
	</tr>


	<%} %>
</table>
</body>
</html>