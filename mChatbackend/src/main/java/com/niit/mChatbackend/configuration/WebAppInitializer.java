package com.niit.mChatbackend.configuration;

//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServIetInitializer;

import org.springframework.web.servlet.support.*;
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{DBConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		//any requests, it will be forwarded to DispatcherServlet
		return new String[]{"/"};

	}

}
