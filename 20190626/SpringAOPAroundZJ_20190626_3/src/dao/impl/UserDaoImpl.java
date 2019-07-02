package dao.impl;

import org.springframework.stereotype.Repository;

import dao.UserDao;
import entity.User;

/*
 * @Repository  当前的这个类是一个DAO组件数据访问层
 */
@Repository
public class UserDaoImpl implements UserDao {

	public User save(User user) {
		// TODO Auto-generated method stub
		// 模拟完成数据库插入的工作
		System.out.println(user.getId() + "--" + user.getUsername() + "--" + user.getPassword());
		return user;
	}

}
