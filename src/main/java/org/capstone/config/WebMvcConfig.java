package org.capstone.config;

import org.capstone.dao.AdminDao;
import org.capstone.dao.AdminDaoImpl;
import org.capstone.dao.BankRegisterDao;
import org.capstone.dao.BankRegisterDaoImpl;
import org.capstone.dao.RequestDao;
import org.capstone.dao.RequestDaoImpl;
import org.capstone.dao.TransactionDao;
import org.capstone.dao.TransactionDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("org.capstone")
public class WebMvcConfig {

	@Bean
	InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver vr = new InternalResourceViewResolver();

		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		return vr;
	}

	@Bean
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/bank?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("nishi");

		return ds;
	}

	@Bean
	public BankRegisterDao getUserDao() {
		return new BankRegisterDaoImpl(getDataSource());
	}
	@Bean
	public AdminDao getUserDao2() {
		return new AdminDaoImpl(getDataSource());
	}
	@Bean
	public TransactionDao getUserDao1() {
		return new TransactionDaoImpl(getDataSource());
	}
	@Bean
	public RequestDao getUserDao3() {
		return new RequestDaoImpl(getDataSource());
	}
}