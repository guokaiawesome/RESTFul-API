package com.monster.demo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.monster.demo.dao.user.UserBaseInfoMapper;
import com.monster.demo.pojo.po.user.UserBaseInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserBaseInfoMapperTest {
	
	/**
	 * 这里需要注意一下，getLogger的时候用类名，这里打印不出日志，用字符串是可以打印的，
	 * 这里字符串可以是logback配置的，也可以是随便写的
	 */
	private static final Logger logger=LoggerFactory.getLogger("junit-test");
	
	@Autowired
	UserBaseInfoMapper  mapper;
	
	@Test
	public void testSelectByPrimaryKey() {
		UserBaseInfo userBaseInfo=mapper.selectByPrimaryKey(1L);
		logger.debug("userBaseInfo: {}",userBaseInfo);
		logger.error("-----------------------hello--------------------------");
		logger.info("userBaseInfo: {}",userBaseInfo);
		System.out.println(userBaseInfo);
	}

}
