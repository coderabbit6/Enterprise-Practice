package cn.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.springdemo.HelloSpring;

public class HelloSpringTest {
	public static void main(String[] args) {
		// ͨ��һ����ClaaPathXmlApplicationContext()���������ļ� ʵ����Spring
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// ͨ��context ��getBean()��������ȡ�����ļ��е�ID
		// HelloSpring helloSpring = new HelloSpring();

		HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
		helloSpring.printMy();
		helloSpring.printWho();

	}
}
