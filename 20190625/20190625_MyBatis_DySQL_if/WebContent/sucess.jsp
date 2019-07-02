<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,cn.smbms.pojo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<User> userlist = (ArrayList<User>) request.getAttribute("user");
for(User user:userlist){
	out.println("userCode: "+user.getUserCode()+"--,userName"+user.getUserName()+"--,userRole:"+user.getUserRole());
}
%>
</body>
</html>