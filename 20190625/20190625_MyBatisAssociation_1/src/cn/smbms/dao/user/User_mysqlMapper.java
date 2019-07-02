package cn.smbms.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.User;

public interface User_mysqlMapper {

	// 两表联查
	public List<User> getUserListTwotable(@Param("userRole") Integer roleId);

	// 1->N
	public List<User> getAddressListByUserId(@Param("id") Integer userId);

}
