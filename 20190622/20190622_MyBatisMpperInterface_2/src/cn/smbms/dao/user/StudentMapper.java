package cn.smbms.dao.user;

import java.util.List;

import cn.smbms.pojo.Student;

/*
 * 对应Mapper.XML 中的ID。来创建方法
 */
public interface StudentMapper {

	// <select id="getStudentList" resultType="Student" >
	// select * from t_student
	// </select>

	public List<Student> getStudentList();
}
