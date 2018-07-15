package com.monster.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monster.demo.constant.CodeAndMsgEnum;
import com.monster.demo.constant.CommonConstant;
import com.monster.demo.response.CommonResponseResult;
import com.monster.demo.response.SuccessResponseResult;



/**
 * 
 * @description 用来映射主页/根目录访问路径
 * @author guokai
 * @date 2018年7月8日
 * @version v1.0
 */
@RestController
public class HelloController {
	
	/**
	 * 
	 * @description 主页欢迎页面
	 * @param id
	 * @return
	 */
	@GetMapping("/")
	public CommonResponseResult hello() {
		SuccessResponseResult ret=new SuccessResponseResult(CommonConstant.SUCCESS, CodeAndMsgEnum.OK.getCode(), CodeAndMsgEnum.OK.getMsg(), "congratulation", new Date());
		Map<String,Object> data=new HashMap<>();
		data.put("document", "https://github.com/guokaiawesome/SpringBoot2-RESTFulAPI");
		ret.setData(data);
		return ret;
	}

}
