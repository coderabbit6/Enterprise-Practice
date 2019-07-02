package spring.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import spring.Bean.Student;
import spring.dao.IStudentDao;
import spring.service.IStudentService;

public class StudentService implements IStudentService {

	@Autowired
	private IStudentDao studentDao;

	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.addStudent(student);

	}

	@Override
	public boolean delStudent(int studentId) {
		// TODO Auto-generated method stub
		return studentDao.delStudent(studentId);
	}

	@Override
	public boolean updStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.updStudent(student);
	}

	@Override
	public List<Student> selStudent(int studentId) {
		// TODO Auto-generated method stub
		return studentDao.selStudent(studentId);
	}

}
