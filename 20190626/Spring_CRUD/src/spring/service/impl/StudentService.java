package spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import spring.Bean.Student;
import spring.dao.IStudentDao;
import spring.service.IStudentService;


public class StudentService implements IStudentService {
	/*
	 * 自动注入
	 */
	@Autowired
	private IStudentDao studentDao;

	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public boolean addStudent(Student student) {
		return studentDao.addStudent(student);
	}

	@Override
	public boolean delStudent(int studentId) {
		return studentDao.delStudent(studentId);
	}

	@Override
	public boolean updStudent(Student student) {
		return studentDao.updStudent(student);
	}
}
