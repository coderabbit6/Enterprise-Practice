package cn.smbms.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.User;

public interface User_mysqlMapper {

	public List<User> getUserList(@Param("userName") String userName, @Param("userRole") Integer userRole);

	public int modify(User user);
}
