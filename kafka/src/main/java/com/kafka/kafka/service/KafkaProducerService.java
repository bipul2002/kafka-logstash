package com.kafka.kafka.service;

public interface KafkaProducerService {
    void sendPersonData(String name,String area, Long age);
}
