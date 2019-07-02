package cn.smbms.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * 读取配置文件
 * 加载配置文件
 * 创建回话工厂
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

	// 创建OPENSESSION的方法
	public static SqlSession createSqlSesion() {
		System.out.println(factory);
		return factory.openSession(true);// true 为自动提交事务
	}

	public static void closeSqlSession(SqlSession sqlSession) {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}

}
