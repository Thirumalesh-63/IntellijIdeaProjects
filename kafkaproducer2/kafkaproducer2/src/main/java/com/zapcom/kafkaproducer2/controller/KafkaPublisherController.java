package com.zapcom.kafkaproducer2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class KafkaPublisherController {

    @Autowired
    private KafkaTemplate<String,Object> template;

    @PostMapping("/publish")
    public void sendMessageToTopic(@RequestParam String message){
        CompletableFuture<SendResult<String, Object>> future = template.send("DEMO-1", message);
        future.whenComplete((result,ex)->{
            if (ex == null) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());
            }
        });

    }
//
//    public void sendEventsToTopic(Customer customer) {
//        try {
//            CompletableFuture<SendResult<String, Object>> future = template.send("javatechie-demo", customer);
//            future.whenComplete((result, ex) -> {
//                if (ex == null) {
//                    System.out.println("Sent message=[" + customer.toString() +
//                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
//                } else {
//                    System.out.println("Unable to send message=[" +
//                            customer.toString() + "] due to : " + ex.getMessage());
//                }
//            });
//
//        } catch (Exception ex) {
//            System.out.println("ERROR : "+ ex.getMessage());
//        }
//    }
}
