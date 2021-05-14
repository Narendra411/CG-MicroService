package com.cap.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.model.Person;

@RestController
public class PersonController {
	
	@RequestMapping("/person/{id}")
	public Person getPerson(@PathVariable("id") int id) {
		
		switch(id) {
		
		case 1: return new Person(1,"Raghu", "Nair"); 
		case 2: return new Person(2,"Raja", "Reddy"); 
		case 3: return new Person(3,"Harishi", "Goud"); 
		case 4: return new Person(4,"Akhili", "Nayudu");
		
		}
		return null;
	}

}
