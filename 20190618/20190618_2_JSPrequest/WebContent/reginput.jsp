<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		请输入注册信息
		<form action="reginfo.jsp" method="post">
			<table border="1">
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="userpwd"></td>
				</tr>
				<tr>
					<td>爱好:</td>
					<td><input type="checkbox" name="userchk" value="java">JAVA<BR />
						<input type="checkbox" name="userchk" value="JS">JS<BR />
						<input type="checkbox" name="userchk" value="CSS">CSS<BR />

					</td>
				</tr>
				<tr>

					<td colspan="2"><input type="submit" value="提交"> <input
						type="reset" value="重置"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>