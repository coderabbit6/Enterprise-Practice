package cn.smbms.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.smbms.dao.user.User_mysqlMapper;
import cn.smbms.pojo.User;
import cn.smbms.utils.MyBatisUtils;

public class MyBatisTest {

	private Logger logger = Logger.getLogger(MyBatisTest.class);

	@Test
	public void testStudentList() {
		SqlSession session = null;
		List<User> stuList = new ArrayList<User>();
		User user = new User();
		user.setUserName("赵");
		user.setUserRole(3);
		// 通过getMapper方式来执行
		try {
			session = MyBatisUtils.createSqlSesion();
			stuList = session.getMapper(User_mysqlMapper.class).getUserList(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtils.closeSqlSession(session);
		}

		for (User stu : stuList) {
			logger.debug(stu.getUserName() + "--" + stu.getUserRole());
		}

	}

	// Map
	@Test
	public void testStudentMap() {
		SqlSession session = null;
		List<User> stuList = new ArrayList<User>();
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("uName", "赵");
		userMap.put("uRole", "3");

		// 通过getMapper方式来执行
		try {
			session = MyBatisUtils.createSqlSesion();
			stuList = session.getMapper(User_mysqlMapper.class).getUserListByMap(userMap);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtils.closeSqlSession(session);
		}

		for (User stu : stuList) {
			logger.debug(stu.getUserName() + "--" + stu.getUserRole());
		}

	}

	// 两表联查
	@Test
	public void testStudentTwoTabl() {
		SqlSession session = null;
		List<User> stuList = new ArrayList<User>();
		User user = new User();
		user.setUserName("赵");
		user.setUserRole(3);

		// 通过getMapper方式来执行
		try {
			session = MyBatisUtils.createSqlSesion();
			stuList = session.getMapper(User_mysqlMapper.class).getUserListTwotable(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtils.closeSqlSession(session);
		}

		for (User stu : stuList) {
			logger.debug(stu.getUserName() + "--" + stu.getUserRole() + "---" + stu.getUserRoleName());
		}

	}

}
