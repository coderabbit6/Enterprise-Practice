package dao.impl;

import org.springframework.stereotype.Repository;

import dao.UserDao;
import entity.User;

/*
 * @Repository  ��ǰ���������һ��DAO������ݷ��ʲ�
 */
@Repository
public class UserDaoImpl implements UserDao {

	public User save(User user) {
		// TODO Auto-generated method stub
		// ģ��������ݿ����Ĺ���
		System.out.println(user.getId() + "--" + user.getUsername() + "--" + user.getPassword());
		return user;
	}

}
