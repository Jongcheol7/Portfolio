package com.englishweb.commons;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class ShowImage implements WebMvcConfigurer{
	
	@Resource(name = "uploadPath")
	String resourcePath;
	
	private String uploadPath = "**";

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(uploadPath)
				.addResourceLocations(resourcePath);
	}
}
