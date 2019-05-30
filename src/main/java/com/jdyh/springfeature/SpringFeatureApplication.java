package com.jdyh.springfeature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.jdyh.springfeature")
@EnableEurekaClient
public class SpringFeatureApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringFeatureApplication.class, args);
	}

}
