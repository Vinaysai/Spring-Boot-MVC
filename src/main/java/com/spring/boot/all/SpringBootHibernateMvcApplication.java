package com.spring.boot.all;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootHibernateMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateMvcApplication.class, args);
	}

	@Bean
	public RestTemplate getTemplate() {

		return new RestTemplateBuilder().build();
	}
}
