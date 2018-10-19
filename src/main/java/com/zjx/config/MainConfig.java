package com.zjx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.zjx.config.condition.LinuxCondition;
import com.zjx.config.condition.WindowsCondition;
import com.zjx.entity.Color;
import com.zjx.entity.Person;
import com.zjx.entity.Red;

@Configuration
//@ComponentScan(basePackages="com.zjx.config.*")
//@ComponentScan(basePackageClasses = MainConfig.class)
/*@ComponentScan(value="com.zjx", excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, classes={Controller.class, Service.class})
})*/
/*@ComponentScan(value="com.zjx", useDefaultFilters=false, includeFilters = {
		@Filter(type = FilterType.ANNOTATION, classes={Controller.class})
})*/
@ComponentScans(value = {
		@ComponentScan(value="com.zjx", useDefaultFilters=false, includeFilters = {
				//@Filter(type = FilterType.ANNOTATION, classes={Controller.class}),
				//@Filter(type = FilterType.ASSIGNABLE_TYPE, classes={Repository.class}),
				@Filter(type = FilterType.CUSTOM, classes={MyTypeFilter.class})
		})
})
@Conditional({WindowsCondition.class})
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig {

	//prototype  singleton
	@Scope("singleton")
	@Bean("person")
	@Lazy
	public Person person() {
		System.out.println("创建person对象。。");
		return new Person("zjx", 18);
	}

	@Bean("bill")
	@Conditional({WindowsCondition.class})
	public Person person1() {
		return new Person("Bill Gates", 18);
	}

	@Bean("linux")
	@Conditional({LinuxCondition.class})
	public Person person2() {
		return new Person("Linux", 22);
	}
}
