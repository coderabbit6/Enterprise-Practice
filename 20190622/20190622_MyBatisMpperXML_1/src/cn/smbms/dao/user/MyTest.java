package cn.smbms.dao.user;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

public class MyTest {
	private Logger logger = Logger.getLogger(MyTest.class);

	@Test
	public void test() {

	}

	@Test
	public void mysqlTest() {
		String resource = "mybatis-config.xml";
		SqlSession sqlsession = null;
		int count = 0;
		// 1.通过流的方式。先加载配置文件mybatis-config.xml
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			// 2.SqlSessionFactory 读取配置文件。进行解析
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			// 3.创建SqlSession，目的是执行SQL
			sqlsession = factory.openSession();
			// 4.调用mapper.xml文件来具体执行某一条SQL语句 namespace+id
			count = sqlsession.selectOne("cn.smbms.dao.user.MySqlTest.count");
			logger.debug("统计结果为：" + count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
