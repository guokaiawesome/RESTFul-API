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

	/**
	 * @description   public 表示public 修饰的方法
	 * 第一个*表示不关心返回值
	 * 第二个*表示controller中的任何类
	 * 第三个*表示类中的任何方法
	 * 括号中的..表示不关心方法的参数
	 */
	@Pointcut("execution(public * com.monster.demo.controller.*.*(..))")
	public void pointCut(){}

	@Around("pointCut()")
	public Object outputLogAndExecute(ProceedingJoinPoint jp) throws Throwable {
		//这里的异常处理需要关注一下，实际测试一下，和统一异常处理的先后顺序
		
		//这一步必须要有返回值，否则controller返回不了任何值
		Object obj=jp.proceed();
		
		return obj;
	}
	
	
	
	
	
	
	}