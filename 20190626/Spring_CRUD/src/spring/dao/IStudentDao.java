package spring.dao;

import spring.Bean.Student;

public interface IStudentDao {
	/**
	 * 添加student的方法
	 * 
	 * @param student
	 * @return
	 */
	boolean addStudent(Student student);

	/**
	 * 删除student的方法
	 * 
	 * @param studentId
	 * @return
	 */
	boolean delStudent(int studentId);

	/**
	 * 修改student的方法
	 * 
	 * @param student
	 * @return
	 */
	boolean updStudent(Student student);
}
