package com.biz.file.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/*
 * Servlet-context.xml을 대신하는 Class(WebConfig)
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.biz.file.controller","com.biz.file.service"})
public class AppServletConfig implements WebMvcConfigurer {

	/*
	 * @Bean은 스프링에 내장된 클래스를 사용할 준비를 위한 Annotation(지시어)
	 */
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/files/**").addResourceLocations("/files/");
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	//file 업로드를 위한 설정
	@Bean
	public MultipartResolver multipartResolver() {
		
		CommonsMultipartResolver mr = new CommonsMultipartResolver();
		
		mr.setMaxUploadSize(1000000000);
		mr.setMaxUploadSizePerFile(10000000);
		
		return mr;
	}
	
}
