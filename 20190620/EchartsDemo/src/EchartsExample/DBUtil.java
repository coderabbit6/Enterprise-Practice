package EchartsExample;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
 * ���ݿ⹤���ࣨ������tomcat jdbc pool��
 * 
 * @author zhong
 *
 */
public class DBUtil {
	
	private static DataSource ds;
	
	static {
		// ����tomcat jdbc pool (���ӳ�)
        PoolProperties p = new PoolProperties();
		p.setUrl("jdbc:mysql://127.0.0.1:3306/test?relaxAutoCommit=true&zeroDateTimeBehavior=convertToNull"); // �������ӵ�url
		p.setDriverClassName("com.mysql.jdbc.Driver"); // �������ݿ�����
		p.setUsername("root"); // ����Զ�����ӵ��û���
		p.setPassword("root"); // ����
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery("SELECT 1");
        p.setTestOnReturn(false);
        p.setValidationInterval(30000);
        p.setTimeBetweenEvictionRunsMillis(30000);
        p.setMaxActive(100);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setRemoveAbandonedTimeout(60);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setMinIdle(10);
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(
          "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
          "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        ds = new DataSource();
        ds.setPoolProperties(p);
	}
	
	private DBUtil() {}
	
	/**
	 * ��ȡһ�����ݿ����ӣ�Connection����
	 * 
	 * @return Database Connection
	 */
	public static Connection getConnection() {
		Connection conn = null;
		
		try {			
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * �رմ����Connection��
	 * 
	 * @param conn
	 *            ���رյ�Connection
	 */
	public static void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �رմ����Statement��
	 * 
	 * @param stmt
	 *            ���رյ�Statement
	 */
	public static void close(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �رմ����ResultSet��
	 * 
	 * @param rs
	 *            ���رյ�ResultSet
	 */
	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
