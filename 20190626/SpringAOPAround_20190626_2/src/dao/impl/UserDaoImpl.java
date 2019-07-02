package dao.impl;

import dao.UserDao;
import entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public int save(User user) {
		// TODO Auto-generated method stub
		// 模拟完成数据库插入的工作
		System.out.println(user.getId() + "--" + user.getUsername() + "--" + user.getPassword());
		return 1;
	}

}
