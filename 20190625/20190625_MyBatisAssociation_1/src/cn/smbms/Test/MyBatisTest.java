package cn.smbms.Test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.smbms.dao.user.User_mysqlMapper;
import cn.smbms.pojo.Address;
import cn.smbms.pojo.User;
import cn.smbms.utils.MyBatisUtils;

public class MyBatisTest {

	private Logger logger = Logger.getLogger(MyBatisTest.class);

	@Test
	public void testStudentList() {
		SqlSession session = null;
		List<User> stuList = new ArrayList<User>();
		Integer id = 3;
		// 通过getMapper方式来执行
		try {
			session = MyBatisUtils.createSqlSesion();
			stuList = session.getMapper(User_mysqlMapper.class).getUserListTwotable(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtils.closeSqlSession(session);
		}

		for (User stu : stuList) {
			logger.debug(stu.getId() + "---" + stu.getUserName() + "--" + stu.getRole().getRoleName() + "--"
					+ stu.getRole().getCreateBy() + "--" + stu.getRole().getRoleCode());
		}

	}

	@Test
	public void getAddressListByUserId() {
		SqlSession session = null;
		List<User> stuList = new ArrayList<User>();
		Integer id = 1;
		// 通过getMapper方式来执行
		try {
			session = MyBatisUtils.createSqlSesion();
			stuList = session.getMapper(User_mysqlMapper.class).getAddressListByUserId(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtils.closeSqlSession(session);
		}

		for (User stu : stuList) {
			logger.debug("userCode: " + stu.getUserCode() + "----" + " userName: " + stu.getUserName());
			for (Address addrs : stu.getAddressList()) {
				logger.debug("AddressId: " + addrs.getId() + "--" + ",contact: " + addrs.getContact() + "--"
						+ ",addressDesc: " + addrs.getAddressDesc() + "---" + ",addressTel: " + addrs.getTel());
			}
		}

	}

}
