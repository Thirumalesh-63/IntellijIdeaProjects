package com.zapcom.kafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class KafkaconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaconsumerApplication.class, args);
	}

}
