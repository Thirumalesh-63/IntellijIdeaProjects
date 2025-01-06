package com.zapcom.kafkaproducer2.controller;

import com.zapcom.kafkaproducer2.model.CsvReadUtils;
import com.zapcom.kafkaproducer2.model.Customer;
import com.zapcom.kafkaproducer2.model.User;
import com.zapcom.kafkaproducer2.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class KafkaPublisherController {

    @Autowired
    private KafkaTemplate<String,Object> template;

    @Autowired
    private CsvReadUtils csvReadUtils;

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/publish")
    public void sendMessageToTopic(@RequestParam String message){
        for (int i = 0; i <= 100000; i++) {
            CompletableFuture<SendResult<String, Object>> future = template.send("publisher-demo", message);
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


    }

    @PostMapping("/customer")
    public void sendEventsToTopic(@RequestBody Customer customer) {
        for (int i = 0; i <= 1000000; i++) {
            try {
                CompletableFuture<SendResult<String, Object>> future = template.send("publisher-demo2", customer);
                future.whenComplete((result, ex) -> {
                    if (ex == null) {
                        System.out.println("Sent message=[" + customer.toString() +
                                "] with offset=[" + result.getRecordMetadata().offset() + "]");
                    } else {
                        System.out.println("Unable to send message=[" +
                                customer.toString() + "] due to : " + ex.getMessage());
                    }
                });

            } catch (Exception ex) {
                System.out.println("ERROR : "+ ex.getMessage());
            }
        }

    }



    @PostMapping("/publishNew")
    public ResponseEntity<?> publishEvent(@RequestBody User user) {
        try {
//            List<User> users = csvReadUtils.readDataFromCsv();
//            users.forEach(usr -> kafkaService.sendEvents(usr));
            kafkaService.sendEvents(user);
            return ResponseEntity.ok("Message published successfully");
        } catch (Exception exception) {
            return ResponseEntity.
                    status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
