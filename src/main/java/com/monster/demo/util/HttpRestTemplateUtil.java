package com.monster.demo.util;

import org.springframework.web.client.RestTemplate;

/**
 * 
 * @description http协议的内部调用
 * resttemplate内部使用的httpclient版本为4.5.5
 * @author guokai
 * @date 2018年7月19日
 * @version v1.0
 */
public class HttpRestTemplateUtil {
	
	public static void getHttpClient() {
		
		new  RestTemplate();
		
	}

}
