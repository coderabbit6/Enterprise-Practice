package dao.impl;

import dao.UserDao;
import entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public int save(User user) {
		// TODO Auto-generated method stub
		// ģ��������ݿ����Ĺ���
		System.out.println(user.getId() + "--" + user.getUsername() + "--" + user.getPassword());
		return 1;
	}

}
