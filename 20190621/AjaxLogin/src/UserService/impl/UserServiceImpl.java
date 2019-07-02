package UserService.impl;

import java.sql.ResultSet;

import UserDao.impl.UserDaoImpl;
import UserService.UserService;
import entity.User;

public class UserServiceImpl implements UserService {
	@Override
	public ResultSet loginUser(String userName, String password) {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User u = new User();
		u.setUserName(userName);
		u.setPassword(password);
		return userDaoImpl.findByNameAndPassword(u.getUserName(), u.getPassword());
	}
}
