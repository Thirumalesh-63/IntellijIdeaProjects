package com.zapcom.kafkaconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    Logger log = LoggerFactory.getLogger(KafkaConsumer.class);


    @KafkaListener(topics = "DEMO-1",groupId = "group1")
    public void consumeEvents(String message) {

        log.info("consumer consume the events {} ", message);
    }
}
