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
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {
		protected final Log logger = LogFactory.getLog(getClass());
		
		@Autowired
		private UserDetailsServiceImpl userDetailsService; 
		
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(daoAuthenticationProvider());
	    }  
	    
	    public MessageSource getMessageSource(){
	    	ReloadableResourceBundleMessageSource source=new ReloadableResourceBundleMessageSource();
	    	source.setBasenames("classpath:/message/security_messages","classpath:org/springframework/security/messages");
	    	source.setDefaultEncoding("UTF-8");
	    	return source;
	    }
		
		public DaoAuthenticationProvider daoAuthenticationProvider(){
			PasswordEncoder encoder=getPasswordEncoder();
			DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
			provider.setMessageSource(getMessageSource());
			provider.setUserDetailsService(userDetailsService);
			provider.setPasswordEncoder(encoder);
			provider.setHideUserNotFoundExceptions(false);
			return provider;
		}
		
		public LoginSuccessHandler loginSuccessHandler(){
			return new LoginSuccessHandler();
		}
		
		public LogoutSuccessHandler logoutSuccessHandler(){
			return new LogoutSuccessHandler();
		}
		
		public LoginFailHandler loginFailHandler(){
			return new LoginFailHandler();
		}
		
		public PasswordEncoder getPasswordEncoder(){
			return new BCryptPasswordEncoder(Constant.BCRYPT_LENGTH);
		}
		
		protected void configure(HttpSecurity http) throws Exception {
			http
	        .authorizeRequests()
	            .antMatchers("/static/**","/robots.txt").permitAll()                
	            .antMatchers("/admin/**").hasRole("ADMIN") 
	            .antMatchers("/userAccount/**").hasAnyAuthority("ROLE_USER")
	            .anyRequest()
	            .authenticated()                                                   
	            .and()
				.formLogin()
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/")
				.successHandler(loginSuccessHandler())
				.failureHandler(loginFailHandler())
				.and()
				.logout()
				.logoutSuccessUrl("/login").permitAll()
				.logoutSuccessHandler(logoutSuccessHandler())
				.and().httpBasic();
		}
	}
}
