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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;

@Configuration
@MapperScan(basePackages= "com.monster.demo.dao.user",sqlSessionFactoryRef="userSqlSessionFactory")
public class UserDataSourceXAConfig {
	
	@Autowired
	UserDBConfig userDBConfig;
	
	@Bean(name="userDataSource")
	public DataSource authDatasource() {
		MysqlXADataSource mysqlXaDatasource=new MysqlXADataSource();
		BeanUtils.copyProperties(userDBConfig, mysqlXaDatasource);
		AtomikosDataSourceBean atomikosDataSouce=new AtomikosDataSourceBean();
		atomikosDataSouce.setXaDataSource(mysqlXaDatasource);
		atomikosDataSouce.setUniqueResourceName("userDataSource");
		return atomikosDataSouce;
		
	}
	
	@Bean("userSqlSessionFactory")
	public SqlSessionFactory authSqlSessionFactory(@Qualifier("userDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory=new SqlSessionFactoryBean();
		//这里试一下用authDatasource()代替dataSource应该也是可以的
		sqlSessionFactory.setDataSource(dataSource);
		//Resource的几种解析方式了解一下
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/user/*.xml"));
		sqlSessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
		return sqlSessionFactory.getObject();
	}
	
	@Bean("userSqlSessionTemplate")
	public SqlSessionTemplate authSqlSessionTemplate(@Qualifier("userSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
