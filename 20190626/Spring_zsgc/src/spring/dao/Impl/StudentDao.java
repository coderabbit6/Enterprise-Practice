package spring.dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import spring.Bean.Student;
import spring.dao.IStudentDao;

public class StudentDao implements IStudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean addStudent(Student student) {
		// 返回标识
		boolean flag = false;
		// 创建SQL
		String sql = "insert into student values(null,?,?,?)";
		// 通过jdbcTemplate 来执行SQL语句
		int row = jdbcTemplate.update(sql, student.getName(), student.getSex(), student.getAge());
		if (row > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean delStudent(int studentId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Student> selStudent(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
