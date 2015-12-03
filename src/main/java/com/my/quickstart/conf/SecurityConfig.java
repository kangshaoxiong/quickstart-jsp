package com.my.quickstart.conf;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.my.quickstart.constants.Constant;
import com.my.quickstart.security.LoginFailHandler;
import com.my.quickstart.security.LoginSuccessHandler;
import com.my.quickstart.security.LogoutSuccessHandler;
import com.my.quickstart.security.UserDetailsServiceImpl;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig{
	
	@Configuration
	//设置拦截/适配器 的执行顺序（值越小优先级越高）
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {
		protected final Log logger = LogFactory.getLog(getClass());
		
		@Autowired
		private UserDetailsServiceImpl userDetailsService; 
		
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(daoAuthenticationProvider());
	    }  
	    
	    /**
	     * 获取操作提示文件的路径
	     * @return
	     */
	    public MessageSource getMessageSource(){
	    	ReloadableResourceBundleMessageSource source=new ReloadableResourceBundleMessageSource();
	    	source.setBasenames("classpath:/message/security_messages","classpath:org/springframework/security/messages");
	    	source.setDefaultEncoding("UTF-8");
	    	return source;
	    }
		
	    /**
	     * 身份认证提供程序
	     * @return
	     */
		public DaoAuthenticationProvider daoAuthenticationProvider(){
			PasswordEncoder encoder=getPasswordEncoder();
			DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
			provider.setMessageSource(getMessageSource());
			provider.setUserDetailsService(userDetailsService);
			//设置密码加密规则
			provider.setPasswordEncoder(encoder);
			provider.setHideUserNotFoundExceptions(false);
			return provider;
		}
		
		/**
		 * 登陆成功处理
		 * @return
		 */
		public LoginSuccessHandler loginSuccessHandler(){
			return new LoginSuccessHandler();
		}
		
		/**
		 * 退出成功处理
		 * @return
		 */
		public LogoutSuccessHandler logoutSuccessHandler(){
			return new LogoutSuccessHandler();
		}
		
		/**
		 * 登陆失败处理
		 * @return
		 */
		public LoginFailHandler loginFailHandler(){
			return new LoginFailHandler();
		}
		
		/**
		 * 密码编码器
		 * @return
		 */
		public PasswordEncoder getPasswordEncoder(){
			return new BCryptPasswordEncoder(Constant.BCRYPT_LENGTH);
		}
		
		protected void configure(HttpSecurity http) throws Exception {
			http
	        .authorizeRequests()
	            //设置不拦截规则
	            .antMatchers("/static/**","/robots.txt").permitAll()                
	            //指定的url需要一直特定的角色
	            .antMatchers("/admin/**").hasRole("ADMIN") 	            
	            //只要有里面设置的任意一个角色/权限
	            .antMatchers("/supervisor/userAccount/**").hasAnyAuthority("ROLE_USER")
	            .anyRequest()
	            //认证
	            .authenticated() 
	            
	            .and()
				.formLogin()
				//自定义登陆页面
				.loginPage("/supervisor/login").permitAll()
				//默认登陆成功的路径
				.defaultSuccessUrl("/supervisor/index")
				//登陆成功后执行的操作
				.successHandler(loginSuccessHandler())
				//登陆失败后执行的操作
				.failureHandler(loginFailHandler())
				
				.and()
				.logout()
				//退出成功后的路径
				.logoutSuccessUrl("/supervisor/login").permitAll()
				//退出成功后执行的操作
				.logoutSuccessHandler(logoutSuccessHandler())
	
				.and().httpBasic();
		}
	}
}
