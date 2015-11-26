package com.my.quickstart;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.my.quickstart.conf.DataSourceProperties;
import com.my.quickstart.constants.ExceptionConstant;
import com.my.quickstart.filter.ExceptionFilter;
import com.my.quickstart.sequence.SequenceDao;
import com.my.quickstart.sequence.impl.DefaultSequenceDao;
import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

@SpringBootApplication
@EnableTransactionManagement 
@EnableJms
@EnableAsync
@EnableScheduling
public class Application extends SpringBootServletInitializer {
	
	@Autowired
	private DataSourceProperties dataProperties;
	@Autowired
	private ExceptionFilter exceptionFilter;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class,args);
	}
	
	@Bean(destroyMethod="close")
	@Primary
	public DataSource dataSource(){
		DataSource dataSource=new DataSource();
		dataSource.setDriverClassName(this.dataProperties.getDriverClassName());
		dataSource.setUrl(this.dataProperties.getUrl());
		dataSource.setUsername(this.dataProperties.getUsername());
		dataSource.setPassword(this.dataProperties.getPassword());
		dataSource.setMaxActive(this.dataProperties.getMaxActive());
		dataSource.setMaxIdle(this.dataProperties.getMaxIdle());
		dataSource.setMinIdle(this.dataProperties.getMinIdle());
		dataSource.setDefaultAutoCommit(this.dataProperties.isDefaultAutoCommit());
		return dataSource;
	}
	
	
	@Bean(name="sequenceDao")
	public SequenceDao getSequenceDao(){
		DefaultSequenceDao dao=new DefaultSequenceDao();
		dao.setDataSource(dataSource());
		return dao;
	}
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
	    return new ExceptionCustomizer();
	}
	/**
	 * 定义异常处理定制器
	 * @author Alan
	 *
	 */
	private static class ExceptionCustomizer implements EmbeddedServletContainerCustomizer {

	    @Override
	    public void customize(ConfigurableEmbeddedServletContainer container) {
	        container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST,ExceptionConstant.PAGE_400));
	        container.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED,ExceptionConstant.PAGE_401));
	        container.addErrorPages(new ErrorPage(HttpStatus.PAYMENT_REQUIRED,ExceptionConstant.PAGE_402));
	        container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN,ExceptionConstant.PAGE_403));
	        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,ExceptionConstant.PAGE_404));
	        container.addErrorPages(new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED,ExceptionConstant.PAGE_405));
	        container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,ExceptionConstant.PAGE_500));
	        container.addErrorPages(new ErrorPage(HttpStatus.GATEWAY_TIMEOUT,ExceptionConstant.PAGE_504));
	    }

	}
	/**
	 * 统一处理编码问题
	 * @return
	 */
	@Bean
	public FilterRegistrationBean encodingFilter(){
		CharacterEncodingFilter filter= new CharacterEncodingFilter();
		FilterRegistrationBean registrationBean=new FilterRegistrationBean();
		registrationBean.setFilter(filter);
		registrationBean.addInitParameter("encoding","UTF-8");
		registrationBean.addInitParameter("forceEncoding", "true");
		registrationBean.setName("encodingFilter");
		registrationBean.addUrlPatterns("/*");
		return registrationBean;
	}
	/**
	 * 添加异常处理
	 * @return
	 */
	@Bean
	public FilterRegistrationBean exceptionFilter() {
	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setFilter(exceptionFilter);
	    registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
	    return registration;
	}
	/**
	 * siteMesh Filter 配置
	 * @return
	 */
	@Bean
	public FilterRegistrationBean siteMeshFilter(){
		FilterRegistrationBean registration=new FilterRegistrationBean();
		registration.setFilter(new SiteMeshFilter());
		registration.setName("sitemeshFilter");
		registration.addUrlPatterns("/*");
		return registration;
	}

}
