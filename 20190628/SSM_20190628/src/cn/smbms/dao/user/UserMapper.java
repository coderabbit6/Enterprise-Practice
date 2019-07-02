package cn.smbms.dao.user;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.User;

public interface UserMapper {

	// Í¨¹ýuserCodeºÍuserPassword

	public User getLoginUser(@Param("userCode") String userCode);
}
