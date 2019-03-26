package com.biz.file.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import oracle.jdbc.driver.OracleDriver;

/*
 * mybatis-context.xml을 대신하는 Class
 * 1.dataSource
 * 2.SqlSessionFactory
 * 3.Mapper
 */
@Configuration
@MapperScan("com.biz.file.mapper")
@EnableTransactionManagement
public class MybatisConfig {
	 //dataSource를 사용할 수 있도록 준비
	//<bean id="ds" class="...BasicDataSource">를 대신한 메소드
	@Bean
	public DataSource ds() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("mybts");
		ds.setPassword("1234");
		
		return ds;
	}
	
	//SqlSessionFactory : Oracle 과 DB를 연결할 때 사용할 Bean
	@Bean
	public SqlSessionFactoryBean SqlSessionFactory() {
		SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
		sf.setDataSource(ds());
		//VO클래스가 있는 패키지 경로
		sf.setTypeAliasesPackage("com.biz.file.model");
		
		return sf;
	}
	
	/*Transaction Manager : 이 method는 Spring에 의해서 직접 호출되는 사항이어서 이름을
							"transactionManeger"에서 변경하면 안된다.
	
	  tx: 최신버전 spring에서는 method이름을 tx로 사용해도 된다.
	  
	  @EnableTransactionManagement 적용되려면 이 method가 선언되어있어야 한다.
	*/
	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager ts = new DataSourceTransactionManager(ds());
		
		return ts;
	}
}
