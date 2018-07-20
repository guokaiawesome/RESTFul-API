package com.monster.demo.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monster.demo.constant.CodeAndMsgEnum;
import com.monster.demo.constant.CommonConstant;
import com.monster.demo.response.CommonResponseResult;
import com.monster.demo.response.SuccessResponseResult;
import com.monster.demo.service.XATransactionTestService;



/**
 * 
 * @description 用来映射主页/根目录访问路径
 * @author guokai
 * @date 2018年7月8日
 * @version v1.0
 */
@RestController
@RequestMapping("/xa/transaction")
public class XATransactionTestController {
	
	@Autowired
	XATransactionTestService xATransactionTestService;
	
	/**
	 * 
	 * @description 主页欢迎页面
	 * @param id
	 * @return
	 */
	@GetMapping("/test")
	public CommonResponseResult hello() {
		SuccessResponseResult ret=new SuccessResponseResult(CommonConstant.SUCCESS, CodeAndMsgEnum.OK.getCode(), CodeAndMsgEnum.OK.getMsg(), "congratulation", LocalDateTime.now());
		
		xATransactionTestService.insertTwoDbTest();
		
		Map<String,Object> data=new HashMap<>();
		data.put("document", "https://github.com/guokaiawesome/SpringBoot2-RESTFulAPI");
		ret.setData(data);
		return ret;
	}

}
