package com.cap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MsDefaultConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDefaultConfigServerApplication.class, args);
	}

}
