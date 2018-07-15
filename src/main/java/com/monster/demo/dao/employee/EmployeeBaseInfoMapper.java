package com.monster.demo.dao.employee;

import com.monster.demo.pojo.po.employee.EmployeeBaseInfo;

public interface EmployeeBaseInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EmployeeBaseInfo record);

    int insertSelective(EmployeeBaseInfo record);

    EmployeeBaseInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EmployeeBaseInfo record);

    int updateByPrimaryKey(EmployeeBaseInfo record);
}