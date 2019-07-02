package UserDao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import UserDao.UserDao;
import utils.DBHelper;

public class UserDaoImpl implements UserDao {
	@Override
	public ResultSet findByNameAndPassword(String username, String password) {
		ResultSet rs = null;
		Connection connection = DBHelper.getConn();
		String sql = " " + " select * from smbms_user" + " where userCode=? and userPassword=?";
		try {
			PreparedStatement ptmt = connection.prepareStatement(sql);
			ptmt.setString(1, username);
			ptmt.setString(2, password);
			rs = ptmt.executeQuery();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}
}
