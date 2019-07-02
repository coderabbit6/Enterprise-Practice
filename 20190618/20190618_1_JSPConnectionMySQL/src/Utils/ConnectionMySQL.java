package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionMySQL {

	public static ResultSet getResult() {
		// 1.链接数据库
		Connection conn = null;
		Statement statmen = null;
		ResultSet rs = null;

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String user = "root";
		String pwd = "root";
		String sql = "select * from user";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			statmen = conn.createStatement();
			rs = statmen.executeQuery(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2.给JPS返回一组数据
		return rs;

	}

}
