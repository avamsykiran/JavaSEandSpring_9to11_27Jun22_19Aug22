package com.cts.spring.iocdemo;

import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.cts.spring.iocdemo")
@PropertySource("classpath:keys.properties")
public class BeanConfig {

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	@Bean
	public LocalDate today() {
		return LocalDate.now();
	}

}