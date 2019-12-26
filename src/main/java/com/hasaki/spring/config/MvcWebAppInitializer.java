package com.hasaki.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web.xmlの代わりに使うJavaベースの設定です。
public class MvcWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };        //指定Web配置类
	}

	@Override
	protected String[] getServletMappings() {//将 DispatcherServlet 映射到 "/" 路径
		return new String[] { "/" };
	}


}
