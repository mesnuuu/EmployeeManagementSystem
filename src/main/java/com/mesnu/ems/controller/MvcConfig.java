package com.mesnu.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mesnu.ems.consumeRest.Quote;

@Configuration
@Controller
public class MvcConfig implements WebMvcConfigurer {

	
	  public void addViewControllers(ViewControllerRegistry registry) {
		  
	//  registry.addViewController("/customLogin").setViewName("my-login");
	  registry.addViewController("/access-denied").setViewName("access-denied");
	  
	  }
	  
		@Bean
		public RestTemplate restTemplate() {
			return new RestTemplate();
		}

		@Autowired
		RestTemplate restTemplate;
		
		@GetMapping("/customLogin")
		public String home(Model model) {

			
			  Quote quote = restTemplate.getForObject(
			  "https://quoters.apps.pcfone.io/api/random", Quote.class);
			  
			  String quoteString = quote.getValue().getQuote();
			  
			  model.addAttribute("quote", quoteString) ;
			 

			return "my-login";

		}
	 

}