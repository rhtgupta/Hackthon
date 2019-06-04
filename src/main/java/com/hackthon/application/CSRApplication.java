package com.hackthon.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.hackthon.controller" })
public class CSRApplication {

	public static void main(String[] args) {
		SpringApplication.run(CSRApplication.class, args);
	}

}
