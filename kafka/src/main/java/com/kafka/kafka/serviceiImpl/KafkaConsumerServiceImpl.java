package com.kafka.kafka.serviceiImpl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerServiceImpl {
    @KafkaListener(topics = "person-topic", groupId = "testing-kafka")
    public void consume(String message) {
        System.out.println("Received message: " + message);

    }
}
