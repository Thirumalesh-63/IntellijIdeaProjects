package com.zapcom.kafkaproducer2.service;


import com.zapcom.kafkaproducer2.model.User;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
public class KafkaService {


    @Autowired
    private KafkaTemplate<String,Object> template;

    public void sendEvents(User user) {
        try {
            CompletableFuture<SendResult<String, Object>> future = template.send("publisher-demo4", user);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent message=[" + user.toString() +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" +
                            user.toString() + "] due to : " + ex.getMessage());
                }
            });
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
