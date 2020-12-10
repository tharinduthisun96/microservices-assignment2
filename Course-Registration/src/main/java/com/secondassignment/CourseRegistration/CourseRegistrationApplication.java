package com.secondassignment.CourseRegistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class CourseRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseRegistrationApplication.class, args);
	}

}
