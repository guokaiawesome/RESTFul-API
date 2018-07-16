package com.monster.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;

/**
 * 
 * @description employee数据库的XA配置，分布式事务交由Atomikos管理
 * @author guokai
 * @date 2018年7月16日
 * @version v1.0
 */
@Configuration
@MapperScan(basePackages= "com.monster.demo.dao.employee",sqlSessionTemplateRef="employeeSqlSessionTemplate")
public class EmployeeDatasourceXAConfig {
	
	@Autowired
	EmployeeDBConfig employeeDBConfig;
	
	@Bean(name="employeeDataSource")
	@Primary
	public DataSource authDatasource() {
		MysqlXADataSource mysqlXaDatasource=new MysqlXADataSource();
		BeanUtils.copyProperties(employeeDBConfig, mysqlXaDatasource);
		AtomikosDataSourceBean atomikosDataSouce=new AtomikosDataSourceBean();
		atomikosDataSouce.setXaDataSource(mysqlXaDatasource);
		atomikosDataSouce.setUniqueResourceName("employeeDataSource");
		return atomikosDataSouce;
		
	}
	
	@Bean("employeeSqlSessionFactory")
	@Primary
	public SqlSessionFactory authSqlSessionFactory(@Qualifier("employeeDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory=new SqlSessionFactoryBean();
		//这里试一下用authDatasource()代替dataSource应该也是可以的
		sqlSessionFactory.setDataSource(dataSource);
		//Resource的几种解析方式了解一下
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/employee/*.xml"));
		sqlSessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
		return sqlSessionFactory.getObject();
	}
	
	@Bean("employeeSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate authSqlSessionTemplate(@Qualifier("employeeSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
