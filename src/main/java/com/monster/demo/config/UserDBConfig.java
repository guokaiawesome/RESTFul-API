package com.monster.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @description user数据库配置
 * 尝试将@Configuration换成compent，官方好像建议只配置一个@configuration
 * @author guokai
 * @date 2018年7月15日
 * @version v1.0
 */
@Configuration
@ConfigurationProperties("monster.datasource.user")
public class UserDBConfig {
	
	private String url;
	
	private String user;
	
	private String password;

	public UserDBConfig() {
		super();
	}

	public UserDBConfig(String url, String user, String password) {
		super();
		this.url = url;
		this.user = user;
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDBConfig [url=" + url + ", user=" + user + ", password=" + password + "]";
	}
	
	
	
	
	

}
