package com.yc.demo.crbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class IndexApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndexApplication.class, args);
	}

}
