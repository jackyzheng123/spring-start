package com.zjx.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zjx.config.BeanLifeConfig;
import com.zjx.entity.ColorFactoryBean;

public class BeanLifeMainTest {
	
	private AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanLifeConfig.class);

	@Test
	public void testBeanLife(){
		System.out.println("容器创建完成。。。");
		
		//工厂Bean获取的是调用getObject创建的对象
		ColorFactoryBean colorFactoryBean1 = (ColorFactoryBean) applicationContext.getBean("colorFactoryBean");
		ColorFactoryBean colorFactoryBean2 = (ColorFactoryBean) applicationContext.getBean("colorFactoryBean");
		System.out.println(colorFactoryBean1 + "\n" + colorFactoryBean2);
		System.out.println(colorFactoryBean1 == colorFactoryBean2);
		
		System.out.println("==============");
		printBeanName();
		applicationContext.close();
	}

	private void printBeanName() {
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		for(String name : beanNames){
			System.out.println(name);
		}
	}
}
