package com.zjx.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import com.zjx.config.MainConfig;
import com.zjx.entity.Blue;
import com.zjx.entity.Person;

public class MainTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Person person = (Person) context.getBean("person");
		System.out.println(person.toString());
	}

	public ApplicationContext application = new AnnotationConfigApplicationContext(MainConfig.class);

	@Test
	public void testBean() {
		System.out.println("容器创建完成");
		Person person = (Person) application.getBean("person");
		System.out.println(person.toString());

		String[] beanName = application.getBeanDefinitionNames();
		for(String name : beanName){
			System.out.println(name);
		}
	}

	@Test
	public void testBean01() {
		Environment env = application.getEnvironment();
		String osName = env.getProperty("os.name");
		System.out.println(osName);
		
		String[] beanName = application.getBeanDefinitionNames();
		for(String name : beanName){
			System.out.println(name);
		}
		
		Blue blue = application.getBean(Blue.class);
		System.out.println(blue);
	}
	
}
