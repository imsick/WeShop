package com.beng.webbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class WebBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebBeApplication.class, args);
	}
}
