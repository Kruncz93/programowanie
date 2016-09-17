package com.kruncz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.kruncz.spring.dao.ContactDAO;
import com.kruncz.spring.dao.ContactDAOImpl;
import com.kruncz.spring.dao.PostDAO;
import com.kruncz.spring.dao.PostDAOImpl;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.kruncz.web.*" })
@Import({ SecurityConfig.class })
public class AppConfig {

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
	    driverManagerDataSource.setUsername("root");
	    driverManagerDataSource.setPassword("Krunczer12");
	    return driverManagerDataSource;
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public ContactDAO getContactDAO() {
		return new ContactDAOImpl(dataSource());
	}
	@Bean
	public PostDAO getPostDAO() {
		return new PostDAOImpl(dataSource());
	}
}