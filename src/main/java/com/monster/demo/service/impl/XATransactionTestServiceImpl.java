package com.monster.demo.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monster.demo.dao.employee.EmployeeBaseInfoMapper;
import com.monster.demo.dao.user.UserBaseInfoMapper;
import com.monster.demo.pojo.po.employee.EmployeeBaseInfo;
import com.monster.demo.pojo.po.user.UserBaseInfo;
import com.monster.demo.service.XATransactionTestService;

@Service
public class XATransactionTestServiceImpl implements XATransactionTestService{

	@Autowired
	UserBaseInfoMapper userBaseInfoMapper;
	
	@Autowired
	EmployeeBaseInfoMapper employeeBaseInfoMapper;
	
	@Transactional
	@Override
	public void insertTwoDbTest() {
		
		UserBaseInfo user=new UserBaseInfo();
		user.setRealName("first_user");
		user.setUid("1111111111");
		user.setNickName("user111");
		user.setGmtCreate(new Date());
		user.setGmtModified(new Date());
		userBaseInfoMapper.insert(user);
		
		//int a=10/0;
		
		EmployeeBaseInfo employee=new EmployeeBaseInfo();
		employee.setRealName("first_employee");
		employee.setNickName("employee111");
		employee.setGmtCreate(new Date());
		employee.setGmtModified(new Date());
		employeeBaseInfoMapper.insert(employee);
		
		System.out.println("---end---");		
		
		
	}

}
