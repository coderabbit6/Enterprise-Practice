package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库工具类
 ** 
 */
public class DBHelper {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/smbms?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static Connection conn = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		return conn;
	}

}
