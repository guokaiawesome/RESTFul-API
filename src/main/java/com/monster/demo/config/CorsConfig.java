package com.monster.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * 
 * @description CORS配置
 * 写法参考自spring5.1.0英文文档 {@link docs.spring.io/spring/docs/5.1.0}
 * @author guokai
 * @date 2018年7月17日
 * @version v1.0
 */
@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//这个需要看下源码
		WebMvcConfigurer.super.addCorsMappings(registry);
		
		
		//这里只是一个demo,最好从数据库读取来动态拦截，当然也可以通过@CrossOrigin注解来实现同样的功能
		registry.addMapping("/api/**").allowedOrigins("","").allowedMethods("PUT").allowedHeaders("custom-header1").exposedHeaders("spider.heaer1").allowCredentials(true).maxAge(3600);
		
		//还可以加其他mapping配置
	}
	
	
	

}
