package com.zjx.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zjx.config.AopConfig;
import com.zjx.service.CalculateService;

public class TestAop {

	@Test
	public void test(){
		ApplicationContext applicationContext  = new AnnotationConfigApplicationContext(AopConfig.class);
		CalculateService calculateService = (CalculateService) applicationContext.getBean("calculateService");
		calculateService.div(10, 5);
	}
}
