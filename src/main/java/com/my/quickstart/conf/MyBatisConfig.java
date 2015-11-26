package com.my.quickstart.conf;

import java.io.IOException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.my.quickstart.base.BaseLogger;
/**
 * mybatis 配置类
 * @author Alan
 *
 */
@Configuration
public class MyBatisConfig extends BaseLogger{
	
	@Value("${mybatis.typeAliasesPackage}")
	private String typeAliasesPackage;

	@Autowired
	private DataSource dataSource;
	
	public SqlSessionFactoryBean sqlSessionFactory() throws IOException{
	    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		SqlSessionFactoryBean sqlSessionFactory=new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setTypeAliasesPackage(this.typeAliasesPackage);
		sqlSessionFactory.setConfigLocation(resolver.getResource("classpath:/myBatisConfig.xml"));
		sqlSessionFactory.setMapperLocations(resolver.getResources("classpath*:sqlmap/*_mapper.xml"));
		return sqlSessionFactory;
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(){
		SqlSessionTemplate sessionTemplate=null;
		try {
			logger.info("开始为Mybatis装载SqlSessionTemplate");
			sessionTemplate=new SqlSessionTemplate(sqlSessionFactory().getObject());
		} catch (Exception e) {
			logger.error("为Mybatis装载SqlSessionTemplate失败，程序退出！");
			e.printStackTrace();
		}
		logger.info("为Mybatis装载SqlSessionTemplate成功！");
		return sessionTemplate;
		
	}

}
