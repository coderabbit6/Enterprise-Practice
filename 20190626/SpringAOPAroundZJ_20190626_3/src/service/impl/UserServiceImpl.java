package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import entity.User;
import service.UserService;

/*
 * @Service("service") ��������ҵ����ʵ����
 * @Autowired  ����ҵ�����DAO��Ĺ�����ϵ
 */
//<bean id="service">
@Service("service")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	public User addNewUser(User user) {
		// TODO Auto-generated method stub
		return dao.save(user);
	}

}
