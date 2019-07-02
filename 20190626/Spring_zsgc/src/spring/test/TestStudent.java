package spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.Bean.Student;
import spring.service.IStudentService;

public class TestStudent {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student stu = new Student();
		stu.setName("lenovo");
		stu.setAge(18);
		stu.setSex("boy");
		IStudentService ist = (IStudentService) ctx.getBean("studentService");
		System.out.println(ist.addStudent(stu));

	}
}
