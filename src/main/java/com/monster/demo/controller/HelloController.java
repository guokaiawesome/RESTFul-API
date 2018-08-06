package com.monster.demo.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monster.demo.constant.CodeAndMsgEnum;
import com.monster.demo.constant.CommonConstant;
import com.monster.demo.response.CommonResponseResult;
import com.monster.demo.response.SuccessResponseResult;



/**
 * 
 * @description 用来映射主页/根目录访问路径
 * 官方说明@CrossOrigin默认是允许所有域名和素有头以及GET HEAD POST方法，以前的*写法源码中已经废弃了
 * 可以既在类上写@CrossOrigin，也可以同时在方法上写，比如类上写一个通用的时间，方法上针对域名
 * 跨域访问的注解的不好之处在于不能通过数据库灵活配置，需要需要更改的话需要发布代码
 * @author guokai
 * @date 2018年7月8日
 * @version v1.0
 */
//@CrossOrigin(maxAge=3600)
@RestController
public class HelloController {
	
	private static final Logger logger=LoggerFactory.getLogger(HelloController.class);
	
	/**
	 * 
	 * @description 主页欢迎页面
	 * @param id
	 * @return
	 */
	@GetMapping("/")
	public CommonResponseResult hello() {
		logger.info("hello-----------------------");
		logger.debug("hello2---------------------");
		SuccessResponseResult ret=new SuccessResponseResult(CommonConstant.SUCCESS, CodeAndMsgEnum.OK.getCode(), CodeAndMsgEnum.OK.getMsg(), "congratulation", LocalDateTime.now());
		Map<String,Object> data=new HashMap<>();
		data.put("document", "https://github.com/guokaiawesome/SpringBoot2-RESTFulAPI");
		ret.setData(data);
		return ret;
	}

}
