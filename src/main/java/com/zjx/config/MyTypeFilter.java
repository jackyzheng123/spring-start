package com.zjx.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * 自定义包扫描配置类
 * 
 * @author Think
 *
 */
public class MyTypeFilter implements TypeFilter {

	@Override
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		// 获取当前类注解的信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		// 获取当前正在扫描类的信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		// 获取当前类资源
		Resource resource = metadataReader.getResource();
		
		String className = classMetadata.getClassName();
		System.out.println(className);
		
		if (className.contains("er")) {
			return true;
		}
		return false;
	}

}
