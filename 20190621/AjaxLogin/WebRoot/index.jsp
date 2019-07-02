<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<script type="text/javascript">
	var xmlHttp;
	var userName;
	var password;
	var usernameContent;
	var passwordContent;

	function loadCheck() {
		usernameContent = document.getElementById("userName");
		if (usernameContent.value.length == 0) {
			document.getElementById("insert").innerHTML = "请输入要查询的内容";
		} else {
			userName = usernameContent.value;
			xmlHttp = createXmlHttpRequest();
			xmlHttp.onreadystatechange = getResult;
			xmlHttp.open("POST", "userList", true);
			xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			var data = "userName=" + userName;
			xmlHttp.send(data);
		}
	}
	function createXmlHttpRequest() {
		if (window.XMLHttpRequest) { //返回值为true时说明是新版本IE或其他浏览器
			return new XMLHttpRequest();
		} else { //返回值为false时说明是老版本IE浏览器（IE5和IE6）
			return new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	function getResult() {
		show = document.getElementById("show");
		//alert(xmlHttp.readyState);
		if (xmlHttp.readyState === 4) {
			if (xmlHttp.status === 200) {
				var result = xmlHttp.responseText;
				var dataObj = JSON.parse(result);
				var lenth = 0;
				for (var i in dataObj) {
					lenth++;
				}
				var s = "";
				for (var i = 0; i < lenth; i++) {
					s += dataObj[i].userCode + "</br>";
				}
				show.innerHTML = s;
			} else {
				//alert("连接失败!xmlHttp.status");
			}
		} else {
			//alert("连接失败!xmlHttp.readyState")
		}
	}
</script>
</head>

<body>
	姓名：
	<input type="text" id="userName" name="userName">
	<input type="button" name="button" value="查询" onclick="loadCheck()">
	<div id="show"></div>
</body>
</html>
