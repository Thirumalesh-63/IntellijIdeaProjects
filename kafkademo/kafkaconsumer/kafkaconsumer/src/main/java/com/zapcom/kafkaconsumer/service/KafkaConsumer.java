package com.zapcom.kafkaconsumer.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zapcom.kafkaproducer2.model.Customer;
import com.zapcom.kafkaproducer2.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



@Service
public class KafkaConsumer {

    Logger log = LoggerFactory.getLogger(KafkaConsumer.class);


    @KafkaListener(topics = "publisher-demo2",groupId = "group3")
    public void consumeEvents(Customer customer) {

        log.info("consumer consume the events {} ", customer.getName());
    }


    @RetryableTopic(attempts = "4")// 3 topic N-1
    @KafkaListener(topics = "publisher-demo4", groupId = "demo-group4")
    public void consumeEvents(User user, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, @Header(KafkaHeaders.OFFSET) long offset) {
        try {

            log.info("Received: {} from {} offset {}", new ObjectMapper().writeValueAsString(user), topic, offset);
            //validate restricted IP before process the records
            List<String> restrictedIpList = Stream.of("32.241.244.236", "15.55.49.164", "81.1.95.253", "126.130.43.183").collect(Collectors.toList());
            if (restrictedIpList.contains(user.getIpAddress())) {
                throw new RuntimeException("Invalid IP Address received !");
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

    @DltHandler
    public void listenDLT(User user, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, @Header(KafkaHeaders.OFFSET) long offset) {
        log.info("DLT Received : {} , from {} , offset {}",user.getFirstName(),topic,offset);
    }
}
