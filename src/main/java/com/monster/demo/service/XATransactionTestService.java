package com.monster.demo.service;

/**
 * 
 * @description 分布式事物：用于测试两个数据库事务回滚
 * @author guokai
 * @date 2018年7月16日
 * @version v1.0
 */
public interface XATransactionTestService {
	
	/**
	 * 
	 * @description 分别向user和employee数据库插入数据，并人为产生异常，测试分布式事务是否回滚
	 */
	void insertTwoDbTest();

}
