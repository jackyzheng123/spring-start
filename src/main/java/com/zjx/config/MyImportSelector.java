package com.zjx.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.zjx.entity.Blue;
import com.zjx.entity.Yellow;

/**
 * 自定义逻辑返回需要导入的组件
 * @author Think
 * @date 2018年10月19日
 */
public class MyImportSelector implements ImportSelector{

	/**
	 * @param importingClassMetadata 获取的注解信息
	 * @return 返回值是导入到容器中的全类名
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		
		return new String[]{"com.zjx.entity.Blue", "com.zjx.entity.Yellow"};
	}

}
