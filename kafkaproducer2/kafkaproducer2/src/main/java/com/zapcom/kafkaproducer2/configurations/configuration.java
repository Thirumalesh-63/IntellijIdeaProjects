package com.zapcom.kafkaproducer2.configurations;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configuration {

    @Bean
    public NewTopic topics(){
        return new NewTopic("DEMO-1",5,(short)1);
    }
}
