package com.zjx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zjx.entity.Color;

@Configuration
public class AwareConfig {

	@Bean
	public Color color(){
		return new Color();
	}
}
