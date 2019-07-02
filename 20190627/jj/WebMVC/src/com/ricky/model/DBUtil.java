package com.ricky.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getConnection() {
		Connection conn = null;
		PropertiesUtils.loadFile("database.properties");
		String url = PropertiesUtils.getPropertyValue("url");
		String username = PropertiesUtils.getPropertyValue("user");
		String password = PropertiesUtils.getPropertyValue("password");
		String driver = PropertiesUtils.getPropertyValue("driver");
		if (conn == null) {
			// 获取连接并捕获异常
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, username, password);
			} catch (Exception e) {
				e.printStackTrace();// 异常处理
			}
		}
		return conn;
	}

}