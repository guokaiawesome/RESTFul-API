package com.monster.demo.dao.employee;

import com.monster.demo.pojo.po.employee.EmployeeSensitiveInfo;

public interface EmployeeSensitiveInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EmployeeSensitiveInfo record);

    int insertSelective(EmployeeSensitiveInfo record);

    EmployeeSensitiveInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EmployeeSensitiveInfo record);

    int updateByPrimaryKey(EmployeeSensitiveInfo record);
}