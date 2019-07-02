package spring.service;

import java.util.List;

import spring.Bean.Student;

public interface IStudentService {
	boolean addStudent(Student student);

	boolean delStudent(int studentId);

	boolean updStudent(Student student);

	List<Student> selStudent(int studentId);
}
