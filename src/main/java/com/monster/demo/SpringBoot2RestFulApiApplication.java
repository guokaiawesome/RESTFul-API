package com.monster.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @description web项目启动入口
 * @author guokai
 * @date 2018年7月16日
 * @version v1.0
 */
@SpringBootApplication
public class SpringBoot2RestFulApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2RestFulApiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			
			System.out.println("Let's inspect the beans provided by Spring Boot:");
			
			String[] beanNames=ctx.getBeanDefinitionNames();
			//Arrays.sort(beanNames);
			for(String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}
}
