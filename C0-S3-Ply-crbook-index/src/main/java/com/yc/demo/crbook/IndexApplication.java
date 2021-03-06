package com.yc.demo.crbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yc.demo.crbook.web.LoginInterceptor;

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class IndexApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(IndexApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user_*", "/cart", "/addCart.do");
		WebMvcConfigurer.super.addInterceptors(registry);

	}

}
