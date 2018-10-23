package com.zjx.entity;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 创建一个Spring定义的FactoryBean
 * 
 * @author zhengjiaxing
 * @date 2018年10月23日
 */
public class ColorFactoryBean implements FactoryBean<ColorFactoryBean> {

	// 返回一个Color对象，这个对象会添加到容器中
	@Override
	public ColorFactoryBean getObject() throws Exception {
		System.out.println("ColorFactoryBean...getObject...");
		return new ColorFactoryBean();
	}

	@Override
	public Class<?> getObjectType() {
		return ColorFactoryBean.class;
	}

	// 是单例？
	// true：这个bean是单实例，在容器中保存一份
	// false：多实例，每次获取都会创建一个新的bean；
	@Override
	public boolean isSingleton() {
		return false;
	}

}
