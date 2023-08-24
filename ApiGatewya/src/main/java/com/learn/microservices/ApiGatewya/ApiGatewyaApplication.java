package com.learn.microservices.ApiGatewya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewyaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewyaApplication.class, args);
	}

}
