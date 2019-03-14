package com.biz.xml.config;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration	// 이 클래스는 config를 담당할클래스다
@EnableWebMvc	// 이  프로젝트가 springMVC 프로젝트이다
@ComponentScan(basePackages = {"com.biz.xml.controller","com.biz.xml.service"})
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/files/**").addResourceLocations("/files/");
		
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

	/*
	 * @Bean Annotation은 @Controller, @Service와 비슷한 역할을 하는데
	 * @Controller, @Service는 사용자(개발자)가 호출하여 사용할 클래스들에 Autowired하는 방식이고
	 * @Bean은 spring(Dispatcher)이 사용할 클래스들에 부여하는 Annotation이다. 
	 * 
	 * @Component Annotation은 구체적으로 Controller나 Service를 명시하지 않고 무루뭉실하게
	 * 사용할 때 쓰는 Annotation이다.
	 */
	@Bean
	public MultipartResolver multipartResolver() {

		/*
		  1. MultipartResolver 인터페이스를 이용해서 mr 객체를 선언하고
		     Multi 인터페이스를 implement 한 Commons 클래스의 생성자로 초기화를 진행 한 후
		*/
		MultipartResolver mr = new CommonsMultipartResolver();
		
		/*
		  다시 mr 객체를 commons 클래스로 1차 형변환 진행 후 setMaxUploadSize와 같은 메서드를
		  호출해서 기능을 사용해야 한다.
		 */
		((CommonsMultipartResolver)mr).setMaxUploadSize(1000000);
		
		
		/*
		  2. Multi 인터페이스를 경우하지 않고 직접 Commos 클래스를 이용하여 resolver 객체를 선언
		     및 생성하여 기능을 수행하도록 사용한다.
		     spring에서 권하는 방식은 아니지만 코드의 번잡함을 없애기 위해서 어쩔 수 없는 선택  
		 */
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		
		resolver.setMaxUploadSize(1000000000); // 한번에 올릴수있는 파일크기
		resolver.setMaxUploadSizePerFile(1000000); // 올릴 파일 1개의 크기
		
		return resolver;
	}
	
	private void test() {
		//ArrayList와 같은 클래스를 사용할 때 일반적인 방식
		ArrayList<String> sList = new ArrayList<String>();
		
		//권장방식:List 인터페이스를 사용해서 선언을 하고 ArrayList를 사용해서 초기화를 하는 방식
		List<String> lList = new ArrayList<String>();
		/*
		  1. 혹시 코드를 작성하는 중에 ArrayList를 LinkedList로 변경하고 싶다 할 때 선언부에서 다음과
		     같이 변경을 하고 나머지 부분 코드를 변경하지 않아도 코드가 정상적으로 작동되는 것을 보장
		*/
		lList = new LinkedList<String>();
		
	}
	
	@Bean
	public InternalResourceViewResolver resolver() {
		
		/*
		 * Controller에서 view를 랜더링할때 servlet-context역할을 대신할 클래스
		 */
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	
}
