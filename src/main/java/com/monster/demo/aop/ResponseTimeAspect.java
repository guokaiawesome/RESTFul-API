package com.monster.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger=LoggerFactory.getLogger(ResponseTimeAspect.class);

	
	@Pointcut("execution(public * com.monster.demo.controller.*(..))")
	public void pointCut(){}

	@Around("pointCut()")
	public void outputLogAndExecute(ProceedingJoinPoint jp) throws Throwable {
		//这里的异常处理需要关注一下，实际测试一下，和统一异常处理的先后顺序
		
		jp.proceed();
	}
	
	
	
	
	
	
	}