package com.ijona.Mobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class MobileApplication {

	public static void main(String[] args) {

		SpringApplication.run(MobileApplication.class, args);

	}
}