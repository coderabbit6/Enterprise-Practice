package com.ricky.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ricky.modelUser.User;

public class GetUser {
	public static List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		Connection conn = DBUtil.getConnection();
		Statement stat = null;
		ResultSet rs = null;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from smbms_user where userRole=3");
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String username = rs.getString(3);
				String password = rs.getString(4);
				User user = new User(id, username, password);
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stat.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userList;
	}

}