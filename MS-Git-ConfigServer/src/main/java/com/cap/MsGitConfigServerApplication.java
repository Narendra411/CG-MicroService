package com.cap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MsGitConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGitConfigServerApplication.class, args);
	}

}
