package com.zjx.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.zjx.entity.Green;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * 当前类的注解信息 BeanDefinitionRegistry.registerBeanDefinition注册bean
	 * 
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean definition1 = registry.containsBeanDefinition("com.zjx.entity.Red");
		boolean definition2 = registry.containsBeanDefinition("com.zjx.entity.Blue");
		if (definition1 && definition2) {
			// 指定bean定义
			BeanDefinition beanDefinition = new RootBeanDefinition(Green.class);
			// 注册一个bean
			registry.registerBeanDefinition("green", beanDefinition);
		}
	}

}
