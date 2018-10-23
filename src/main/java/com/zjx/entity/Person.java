package com.zjx.entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Person implements InitializingBean, DisposableBean {

	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Person() {
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	/**
	 * 指定Person初始化方法
	 */
	public void initPerson(){
		System.out.println("指定Person初始化方法...");
	}
	
	/**
	 * 指定Person销毁方法
	 */
	public void destroyPerson(){
		System.out.println("指定Person销毁方法...");
	}

	/**
	 * 实现InitializingBean初始化bean
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("实现InitializingBean初始化bean...");
	}

	/**
	 * 实现DisposableBean销毁bean
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println("实现DisposableBean销毁bean...");
	}

	@PostConstruct
	public void initBean() {
		System.out.println("使用JSR250注解 @PostConstruct初始化bean");
	}
	
	@PreDestroy
	public void destroyBean(){
		System.out.println("使用JSR250注解 @PreDestroy销毁bean");
	}
}
