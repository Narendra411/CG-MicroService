package com.cap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.cap.model.Person;

@Controller
public class PersonController {

	@Autowired
	private RestTemplate restTemplate;


	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		
		return builder.build();
		
	}
	
	@RequestMapping("/")
	public @ResponseBody String hello() {
		return "have a nice day";
	}
	
	
	@RequestMapping(path = "/getperson", params= {"personid"})
	public String getPersonDetails(@RequestParam String personid, Model m) {
		
		Person obj = restTemplate.getForObject("http://person-service/person/" + personid, Person.class);
		m.addAttribute("person",obj);
			
		
		return "console";
		
	}
	
	
	
}

