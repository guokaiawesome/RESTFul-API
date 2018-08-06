package com.monster.demo.service.impl;

import java.time.LocalDateTime;
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
		user.setRealName("second_user");
		user.setUid("222222");
		user.setNickName("user222");
		user.setGmtCreate(LocalDateTime.now());
		user.setGmtModified(LocalDateTime.now());
		userBaseInfoMapper.insert(user);
		
		
		EmployeeBaseInfo employee=new EmployeeBaseInfo();
		employee.setRealName("second_employee");
		employee.setNickName("employee222");
		employee.setGmtCreate(LocalDateTime.now());
		employee.setGmtModified(LocalDateTime.now());
		employeeBaseInfoMapper.insert(employee);
		
		int a=10/0;
		
		System.out.println("---end---");		
		
		
	}

}
