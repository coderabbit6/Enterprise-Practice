<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.stmcc.test.Utils.*"%>
<%@ page import="com.stmcc.test.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	int pageNo = 1;
	int pageSize = 5;
	String pageNoString = request.getParameter("pageNo");
	if (pageNoString != null) {
		pageNo = Integer.parseInt(pageNoString);
	}
	PageModel pageModel = StuManager.getInstance().findStudentList(pageNo, pageSize);
%>

<script type="text/javascript">
	function topPage() {
		window.self.location = "index.jsp?pageNo=<%=pageModel.getTopPageNo()%>";
	}

	function previoPage() {
		window.self.location = "index.jsp?pageNo=<%=pageModel.getPreviousPageNo()%>";
	}

	function nextPage() {
		window.self.location = "index.jsp?pageNo=<%=pageModel.getNextPageNo()%>";
	}

	function bottomPage() {
		window.self.location = "index.jsp?pageNo=<%=pageModel.getBottomPageNo()%>";
	}
</script>

<body>


	<center>
		<table border="1" cellpadding="0" cellspacing="0" width="500">
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>性别</td>
				<td>班级</td>
			</tr>
			<%
				List stulist = pageModel.getList();
				for (Iterator<Student> iter = stulist.iterator(); iter.hasNext();) {
					Student stu = iter.next();
			%>
			<tr>
				<td><%=stu.getS_id()%></td>
				<td><%=stu.getS_name()%></td>
				<td><%=stu.getS_age()%></td>
				<td><%=stu.getS_sex()%></td>
				<td><%=stu.getS_class()%></td>
			</tr>

			<%
				}
			%>

			<tr>
				<td colspan="5">共<%=pageModel.getTotalPages()%> 页
					&nbsp;&nbsp;&nbsp; 当前是<%=pageModel.getPageNo()%>页
					&nbsp;&nbsp;&nbsp; <input type="button" value="首页"
					onClick="topPage()">&nbsp;&nbsp;&nbsp; <input type="button"
					value="上一页" onClick="previoPage()">&nbsp;&nbsp;&nbsp; <input
					type="button" value="下一页" onClick="nextPage()">&nbsp;&nbsp;&nbsp;
					<input type="button" value="末页" onClick="bottomPage()">&nbsp;&nbsp;&nbsp;

				</td>
			</tr>


		</table>
	</center>
</body>
</html>