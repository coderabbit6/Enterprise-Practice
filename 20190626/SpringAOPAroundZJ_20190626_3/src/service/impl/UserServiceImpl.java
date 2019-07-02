package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import entity.User;
import service.UserService;

/*
 * @Service("service") 声明的是业务层的实现类
 * @Autowired  声明业务层与DAO层的关联关系
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
