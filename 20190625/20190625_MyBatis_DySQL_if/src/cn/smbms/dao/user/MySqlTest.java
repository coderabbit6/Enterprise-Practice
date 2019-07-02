package cn.smbms.dao.user;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.smbms.pojo.User;
import cn.smbms.utils.MyBatisUtils;

public class MySqlTest {
	private Logger logger = Logger.getLogger(MySqlTest.class);

	@Test
	public void TestModify() {
		int count = 0;
		SqlSession sqlsession = null;
		try {
			User user = new User();
			user.setId(47);
			user.setUserPassword("11111");
			sqlsession = MyBatisUtils.createSqlSesion();
			count = sqlsession.getMapper(User_mysqlMapper.class).modify(user);
			sqlsession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlsession.rollback();
			count = 0;
		} finally {
			MyBatisUtils.closeSqlSession(sqlsession);
		}
		logger.debug("TestModify--->  " + count);
	}

}
