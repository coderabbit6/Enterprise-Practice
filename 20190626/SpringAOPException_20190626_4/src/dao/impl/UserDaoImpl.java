package dao.impl;

import org.springframework.stereotype.Repository;

import dao.UserDao;
import entity.User;

/*
 * @Repository  ��ǰ���������һ��DAO������ݷ��ʲ�
 */
@Repository
public class UserDaoImpl implements UserDao {

	public void save(User user) {
		// TODO Auto-generated method stub
		// ģ��������ݿ����Ĺ���
		System.out.println("�������С���������");
		throw new RuntimeException("�쳣�׳���ǿ��Ϣ����������������");

	}

}
