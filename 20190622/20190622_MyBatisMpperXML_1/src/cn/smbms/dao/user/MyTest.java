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
		// 1.ͨ�����ķ�ʽ���ȼ��������ļ�mybatis-config.xml
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			// 2.SqlSessionFactory ��ȡ�����ļ������н���
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			// 3.����SqlSession��Ŀ����ִ��SQL
			sqlsession = factory.openSession();
			// 4.����mapper.xml�ļ�������ִ��ĳһ��SQL��� namespace+id
			count = sqlsession.selectOne("cn.smbms.dao.user.MySqlTest.count");
			logger.debug("ͳ�ƽ��Ϊ��" + count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
