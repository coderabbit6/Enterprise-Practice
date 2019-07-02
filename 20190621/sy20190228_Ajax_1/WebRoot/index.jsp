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
	function validate() {
		var name = $("#name").val();
		if (name == null || name == "") {
			$("#nameDiv").html("用户名不能为空！");
		} else {
			//1.创建XMLHttpRequest对象
			xmlHttpRequest = createXmlHttpRequest();
			//2.设置回调函数
			xmlHttpRequest.onreadystatechange = callBack;
			//3.初始化XMLHttpRequest组件
			var url = "userServlet?name=" + name;//服务器端URL地址,name为用户名文本框获取的值
			xmlHttpRequest.open("GET", url, true);
			//4.发送请求
			xmlHttpRequest.send(null);
			/* 使用POST方式发送请求
			var url = "userServlet";//服务器端URL地址
			xmlHttpRequest.open("POST", url, true);
			xmlHttpRequest.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			var data = "name=" + name;//需要发送的数据信息,name为用户名文本框获取的值
			xmlHttpRequest.send(data);
            */
			//Ajax 回调函数
			function callBack() {
				if (xmlHttpRequest.readyState == 4
						&& xmlHttpRequest.status == 200) {
					var data = xmlHttpRequest.responseText;
					alert(typeof(data));
					if (data == "true") {
						$("#nameDiv").html("用户名已被使用！");
					} else {
						$("#nameDiv").html("用户名可以使用！");
					}
				}
			}//end of callBack()
		}
	}//end of validate()

	/*
	 *创建XMLHttpRequest对象
	 */
	function createXmlHttpRequest() {
		if (window.XMLHttpRequest) {//返回值为true时说明是新版本IE或其他浏览器
			return new XMLHttpRequest();
		} else {//返回值为false时说明是老版本IE浏览器（IE5和IE6）
			return new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
</script>
</head>

<body>
	<form action="" id="form1">
		<table>
			<tr>
				<td>用 户 名：</td>
				<td><input type="text" name="name" id="name"
					onblur="validate();" />&nbsp;<font color="#c00fff">*</font></td>
				<td>
					<div id="nameDiv" style="display: inline"></div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
