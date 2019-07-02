package dao;

import entity.User;

public interface UserDao {

	/*
	 * 添加DAO接口，实现插入数据的方法
	 */
	public void save(User user);
}
