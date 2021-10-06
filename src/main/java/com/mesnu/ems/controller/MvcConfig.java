package com.mesnu.ems.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	
	  public void addViewControllers(ViewControllerRegistry registry) {


	  registry.addViewController("/customLogin").setViewName("my-login");
	  registry.addViewController("/access-denied").setViewName("access-denied");
	  
	  }
	 

}