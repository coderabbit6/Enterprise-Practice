package cn.smbms.dao.user;

import java.util.List;

import cn.smbms.pojo.Student;

/*
 * ��ӦMapper.XML �е�ID������������
 */
public interface StudentMapper {

	// <select id="getStudentList" resultType="Student" >
	// select * from t_student
	// </select>

	public List<Student> getStudentList();
}
