package com.cap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

import com.cap.Application.TollProcessTask;

@SpringBootApplication
@EnableTask
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public TollProcessTask tollProcessTask() {
		return new TollProcessTask();

}
	
	public class TollProcessTask implements CommandLineRunner{

		@Override
		public void run(String... args) throws Exception {
			
			for(String i : args)
			System.out.println("Arguments entered in Command Line Runner\t"+i);
		}
		

	}

}// Main Class
