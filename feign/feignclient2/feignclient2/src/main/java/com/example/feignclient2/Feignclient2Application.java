package com.example.feignclient2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Feignclient2Application {

	public static void main(String[] args) {
		SpringApplication.run(Feignclient2Application.class, args);
	}

}
