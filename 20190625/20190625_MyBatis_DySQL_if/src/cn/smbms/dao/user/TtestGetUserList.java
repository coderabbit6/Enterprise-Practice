package cn.smbms.dao.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import cn.smbms.pojo.User;
import cn.smbms.utils.MyBatisUtils;

public class TtestGetUserList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		SqlSession sqlSession = null;
		List<User> userList = new ArrayList<User>();
		sqlSession = MyBatisUtils.createSqlSesion();
		try {
			String userName = req.getParameter("userName");
			String roleId = req.getParameter("roleId");
			System.out.println(userName);
			System.out.println(roleId);
			Integer roid = null;
			if (userName.equals("")) {
				// 为后续的动态SQL传值使用
				userName = "";
			}
			if (!("".equals(roleId))) {
				roid = Integer.parseInt(roleId);
			}
			userList = sqlSession.getMapper(User_mysqlMapper.class).getUserList(userName, roid);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyBatisUtils.closeSqlSession(sqlSession);
		}
		for (User user : userList) {
			System.out.println("userCode: " + user.getUserCode() + "--,userName" + user.getUserName() + "--,userRole:"
					+ user.getUserRole());
		}
		req.setAttribute("user", userList);
		req.getRequestDispatcher("sucess.jsp").forward(req, resp);
	}

}
