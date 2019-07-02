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

<title>My JSP 'Login_success.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
<link rel="stylesheet" href="css/bootstrap.css">
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

	<table id="dg" title="Client Side Pagination"
		style="width:850px;height:300px"
		data-options="
				rownumbers:true,
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10">
		<thead>
			<tr>
				<th field="inv" width="80">Inv No</th>
				<th field="date" width="100">Date</th>
				<th field="name" width="80">Name</th>
				<th field="amount" width="80" align="right">Amount</th>
				<th field="price" width="80" align="right">Price</th>
				<th field="cost" width="100" align="right">Cost</th>
				<th field="note" width="110">Note</th>
				<th field="Sal" width="90">sal</th>
			</tr>
		</thead>
	</table>
	<script type="text/javascript">
		window.onload = function() {
			var xmlhttp = getXmlHttpRequest();
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					json = eval(xmlhttp.responseText);
					for (var i = 0; i < json.length; i++) {
						console.log(json[i].id + "--" + json[i].name + "--" + json[i].price + "--");
						var arr1 = new Array(json.length);
						 
					}
	
				}
			};
		 
			//post请求方式，参数设置
			xmlhttp.open("GET", "${pageContext.request.contextPath}/ajax5");
	
			xmlhttp.send(null);
	
			function getXmlHttpRequest() {
				if (window.XMLHttpRequest) { //返回值为true时说明是新版本IE或其他浏览器
					return new XMLHttpRequest();
				} else { //返回值为false时说明是老版本IE浏览器（IE5和IE6）
					return new ActiveXObject("Microsoft.XMLHTTP");
				}
			}
			function getData() {
				var rows = [];
				for (var i = 1; i <= 800; i++) {
					var amount = Math.floor(Math.random() * 1000);
					var price = Math.floor(Math.random() * 1000);
					rows.push({
						inv :  'Inv No ' + i,
						date : $.fn.datebox.defaults.formatter(new Date()),
						name : 'Name ' + i,
						amount : amount,
						price : price,
						cost : amount * price,
						note : 'Note ' + i,
						sal : 'Sal ' + i
					});
				}
				return rows;
			}
	
			function pagerFilter(data) {
				if (typeof data.length == 'number' && typeof data.splice == 'function') { // is array
					data = {
						total : data.length,
						rows : data
					}
				}
				var dg = $(this);
				var opts = dg.datagrid('options');
				var pager = dg.datagrid('getPager');
				pager.pagination({
					onSelectPage : function(pageNum, pageSize) {
						opts.pageNumber = pageNum;
						opts.pageSize = pageSize;
						pager.pagination('refresh', {
							pageNumber : pageNum,
							pageSize : pageSize
						});
						dg.datagrid('loadData', data);
					}
				});
				if (!data.originalRows) {
					data.originalRows = (data.rows);
				}
				var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
				var end = start + parseInt(opts.pageSize);
				data.rows = (data.originalRows.slice(start, end));
				return data;
			}
	
			$(function() {
				$('#dg').datagrid({
					loadFilter : pagerFilter
				}).datagrid('loadData', getData());
			});
		}
	</script>
</body>
</html>
