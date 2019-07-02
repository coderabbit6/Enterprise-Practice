package service.impl;

import dao.UserDao;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao dao;

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public int addNewUser(User user) {
		// TODO Auto-generated method stub
		return dao.save(user);
	}

	public void addNewUser(User user, int i) {
		// return 1;
	}

}
