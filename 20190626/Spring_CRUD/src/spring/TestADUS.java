package spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.Bean.Student;
import spring.service.IStudentService;

public class TestADUS {
	@Test
	public void testAdd() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 创建Student类对象
		Student student = new Student();
		student.setName("zhangsan");
		student.setSex("boy");
		student.setAge(18);
		// 获取StudentService
		IStudentService studentService = (IStudentService) ac.getBean("studentService");
		// 添加Student
		boolean b = studentService.addStudent(student);
		System.out.println(b);
	}

	@Test
	public void testDel() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取StudentService
		IStudentService studentService = (IStudentService) ac.getBean("studentService");
		// 删除Student
		boolean b = studentService.delStudent(1);
		System.out.println(b);
	}

	@Test
	public void textUpd() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 创建Student类对象
		Student student = new Student();
		student.setId(2);
		student.setName("lisi");
		student.setSex("boy");
		student.setAge(18);
		// 获取StudentService
		IStudentService studentService = (IStudentService) ac.getBean("studentService");
		// 修改Student
		boolean b = studentService.updStudent(student);
		System.out.println(b);
	}

}
