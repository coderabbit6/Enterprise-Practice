package cn.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.springdemo.HelloSpring;

public class HelloSpringTest {
	public static void main(String[] args) {
		// 通过一个叫ClaaPathXmlApplicationContext()加载配置文件 实例化Spring
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 通过context 的getBean()方法来获取配置文件中的ID
		// HelloSpring helloSpring = new HelloSpring();

		HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
		helloSpring.printMy();
		helloSpring.printWho();

	}
}
