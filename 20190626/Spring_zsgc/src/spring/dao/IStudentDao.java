package spring.dao;

import java.util.List;

import spring.Bean.Student;

public interface IStudentDao {

	boolean addStudent(Student student);

	boolean delStudent(int studentId);

	boolean updStudent(Student student);

	List<Student> selStudent(int studentId);
}
