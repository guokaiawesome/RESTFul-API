package com.monster.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 
 * @description 接口响应时间aop
 * @author guokai
 * @date 2018年7月17日
 * @version v1.0
 */
@Component
@Aspect
public class ResponseTimeAspect {
	
	@Pointcut("execution(public * com.monster.demo.controller.*(..))")
	public void pointCut(){}

	
	@Around("pointCut()")
	public void doAround(JoinPoint joinPoint) {
		
	}
	
	
	
	
	
	}