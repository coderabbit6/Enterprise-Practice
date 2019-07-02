package cn.smbms.Test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.smbms.dao.user.StudentMapper;
import cn.smbms.pojo.Student;
import cn.smbms.utils.MyBatisUtils;

public class MyBatisTest {

	private Logger logger = Logger.getLogger(MyBatisTest.class);

	@Test
	public void testStudentList() {
		SqlSession session = null;
		List<Student> stuList = new ArrayList<Student>();
		// 通过getMapper方式来执行
		try {
			session = MyBatisUtils.createSqlSesion();
			System.out.println(session);
			// stuList =
			// session.selectList("cn.smbms.dao.user.StudentMapper.getStudentList");
			stuList = session.getMapper(StudentMapper.class).getStudentList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtils.closeSqlSession(session);
		}

		for (Student stu : stuList) {
			logger.debug(stu.getS_id() + "--" + stu.getS_name() + "--" + stu.getS_sex());
		}

	}

}
