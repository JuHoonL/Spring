package com.biz.xml.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppinitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

//		Class[] rootClass = new Class[] {RootConfig.class};
//		
//		return rootClass;
		
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] { "/" };
	}


}
