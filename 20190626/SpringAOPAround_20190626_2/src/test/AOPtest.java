package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.User;
import service.UserService;

public class AOPtest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) ctx.getBean("service");

		User user = new User();
		user.setId(100);
		user.setUsername("administrator");
		user.setPassword("guest");
		user.setEmail("abcd@163.com");

		System.out.println(service.addNewUser(user));
	}

}
