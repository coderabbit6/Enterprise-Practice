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

<title>My JSP 'welcome.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript"
	src="http://www.jeasyui.com/easyui/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<style type="text/css">
.btn-primary {
	background-color: #6f42c1;
	border-color: white;
}

h1 {
	color: #6f42c1;
}

.alert-success {
	size: 200px;
}

.container-small {
	max-width: 250px;
}
</style>
</head>

<body>
	<h1 align="center">登录成功</h1>
	<!-- 用户登录界面-->
	<div class="jumbotron" align="center">
		<div class="container container-small">
			<h1>Hello!</h1>
			<h2>
				亲爱的<%=request.getParameter("userName")%>欢迎您！ <a href="index.jsp">注销</a>
			</h2>
			<br>
		</div>
	</div>
	<div style="margin:20px 0;"></div>
	<script type="text/javascript">
		$(function() {
			//创建data_grid
			$("#st").datagrid({
				url : 'ajax5', //数据来源   
				//冻结列
				//列的定义
				columns : [ [
					{
						field : 'sno',
						title : '学生编号',
						width : 50
					},
					{
						field : 'sname',
						title : '学生姓名',
						width : 50
					},
					{
						field : 'ssex',
						title : '性别',
						width : 50,
						align : 'right'
					},
					{
						field : 'sbirthday',
						title : '生日',
						width : 50,
						align : 'center',
						hidden : true
					},
					{
						field : 'sclass',
						title : '班级',
						width : 50,
						align : 'right',
						sortable : true
					}
				] ],
	
				fitColumns : true, //列自适应宽度，不能和冻结列同时设置为true
				striped : true, //斑马线效果
				idField : 'sno', //主键列
				rownumbers : true, //显示行号
				singleSelect : false, //是否单选
				pagination : true, //显示分页栏
				pageList : [ 10, 20, 50, 100 ], //每页行数选择列表
				pageSize : 10, //出事每页行数
				remoteSort : false, //是否服务器端排序，设成false，才能客户端排序
				sortName : 'sclass' //设置排序列
			});
		})
	</script>
	学生表
	<br>
	<br>
	<table id="st"></table>
</body>
</html>
