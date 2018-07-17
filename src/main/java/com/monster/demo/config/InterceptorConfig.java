package com.monster.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.monster.demo.interceptor.AccessTokenInterceptor;
import com.monster.demo.interceptor.StaticResourcesInterceptor;

/**
 * 
 * @description 拦截器相关配置
 * 写法参考自spring5.1.0英文文档 {@link docs.spring.io/spring/docs/5.1.0}
 * @author guokai
 * @date 2018年7月17日
 * @version v1.0
 */
@Configuration
@EnableWebMvc
public class InterceptorConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//这句话要不要，spring5.1.0官方文档上没有
		WebMvcConfigurer.super.addInterceptors(registry);
		
		//某个拦截器对应的不需要拦截的url path
		List<String> accessTokenExcludePathPatterns=new ArrayList<>();
		//这里暂时写死，最好放在数据库动态配置
		//静态资源不拦截
		accessTokenExcludePathPatterns.add("/static");
		
		//下面写法参考spring5.1.0官方写法，还需要改
		registry.addInterceptor(new LocaleChangeInterceptor());
		registry.addInterceptor(new AccessTokenInterceptor()).addPathPatterns("/**").excludePathPatterns(accessTokenExcludePathPatterns);
		registry.addInterceptor(new StaticResourcesInterceptor()).addPathPatterns("/static");
		
	}

	
	
}
