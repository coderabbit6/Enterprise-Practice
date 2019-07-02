package spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import spring.Bean.Student;
import spring.dao.IStudentDao;

public class StudentDao implements IStudentDao {
	@Override
	public boolean addStudent(Student student) {
		boolean flag = false;
		// 添加数据的Sql语句
		String addSql = "insert into student values(null,?,?,?)";
		// 执行Sql语句
		int row = jdbcTemplate.update(addSql, student.getName(), student.getSex(), student.getAge());
		if (row > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean delStudent(int studentId) {
		boolean flag = false;
		// 删除数据的Sql语句
		String delSql = "delete from student where id = ?";
		// 执行Sql语句
		int row = jdbcTemplate.update(delSql, studentId);
		if (row > 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updStudent(Student student) {
		boolean flag = false;
		// 修改数据的Sql语句
		String updSql = "update student set name = ?,sex = ?,age = ? where id = ?";
		// 执行语句
		int row = jdbcTemplate.update(updSql, student.getName(), student.getSex(), student.getAge(), student.getId());
		if (row > 0) {
			flag = true;
		}
		return flag;
	}

	/*
	 * 自动注入
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
