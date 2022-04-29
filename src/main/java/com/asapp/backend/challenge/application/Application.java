package com.asapp.backend.challenge.application;

import com.asapp.backend.challenge.application.filter.TokenValidatorFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public FilterRegistrationBean<TokenValidatorFilter> logFilter() {
		FilterRegistrationBean<TokenValidatorFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new TokenValidatorFilter());
		registrationBean.addUrlPatterns("/messages");
		return registrationBean;
	}
}
