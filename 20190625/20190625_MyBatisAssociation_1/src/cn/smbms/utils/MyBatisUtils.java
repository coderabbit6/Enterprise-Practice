package cn.smbms.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * ��ȡ�����ļ�
 * ���������ļ�
 * �����ػ�����
 */
public class MyBatisUtils {

	private static SqlSessionFactory factory;

	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ����OPENSESSION�ķ���
	public static SqlSession createSqlSesion() {
		System.out.println(factory);
		return factory.openSession(true);// true Ϊ�Զ��ύ����
	}

	public static void closeSqlSession(SqlSession sqlSession) {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}

}
