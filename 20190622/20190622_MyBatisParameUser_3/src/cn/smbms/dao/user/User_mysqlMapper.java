package cn.smbms.dao.user;

import java.util.List;
import java.util.Map;

import cn.smbms.pojo.User;

public interface User_mysqlMapper {
	// <select id="getUserList" resultType="User" paramenterType="User">

	public List<User> getUserList(User user);

	// map
	public List<User> getUserListByMap(Map<String, String> userMap);

	// 两表联查
	public List<User> getUserListTwotable(User user);
}
