package com.cap.util;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class CustomerHealthCheckUtil implements HealthIndicator {
	private int errorCode=0;
	@Override
	public Health health() {

		System.out.println("Health check performed. Error code is "+errorCode);
		if(errorCode>2 && errorCode<5){
			++errorCode;
			return Health.down().withDetail(" -->> Custom Error Code ", errorCode).build();
		}
		errorCode++;
		return Health.up().build();
	}
	
}
