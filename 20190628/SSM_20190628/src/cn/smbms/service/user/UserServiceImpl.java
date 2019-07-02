package cn.smbms.service.user;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;

@Service
public class UserServiceImpl implements UserService {

	private Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Resource
	private UserMapper userMapper;

	@Override
	public User login(String userCode, String userPassword) {
		User user = null;
		user = userMapper.getLoginUser(userCode);
		if (null != user) {
			if (!user.getUserPassword().equals(userPassword)) {
				user = null;
			}
		}
		return user;
	}

}
