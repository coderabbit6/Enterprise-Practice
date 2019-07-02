<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#name").blur(function() {
		var name = this.value;
		if (name == null || name == "") {
			$("#nameDiv").html("用户名不能为空！");
		} else {
			$.ajax({
                "url"       : "userServlet",   //要提交的URL路径
                "type"      : "GET",           //发送请求的方式
                "data"      : "name="+name,    //要发送到服务器的数据
                "dataType"  : "text",          //指定返回的数据格式
                "success"   : callBack,        //响应成功后要执行的代码
                "error"     : function() {     //请求失败后要执行的代码
                    alert("用户名验证时出现错误，请稍后再试或与管理员联系！");
                }
            });

			//响应成功时的回调函数
			function callBack(data) {
				if (data == "true") {
					$("#nameDiv").html("用户名已被使用！");
				} else {
					$("#nameDiv").html("用户名可以使用！");
				}
			}//end of callBack()
		}
	});//end of blur()
});
</script>
  </head>
  
  <body>
    <form action="" id="form1">
		<table>
			<tr>
				<td>用 户 名：</td>
				<td><input type="text" name="name" id="name" />&nbsp;<font color="#c00fff">*</font></td>
				<td>
					<div id="nameDiv" style="display: inline"></div></td>
			</tr>
		</table>
	</form>
  </body>
</html>
