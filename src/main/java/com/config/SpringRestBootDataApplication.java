package com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com")
@EnableWebMvc
@EntityScan(basePackages="com.model")
@EnableJpaRepositories(basePackages = "com.repository")
public class SpringRestBootDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestBootDataApplication.class, args);
	}
}
