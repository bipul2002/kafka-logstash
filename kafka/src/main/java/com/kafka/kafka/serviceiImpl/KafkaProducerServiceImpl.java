package com.kafka.kafka.serviceiImpl;

import com.kafka.kafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    @Override
    public void sendPersonData(String name, String area, Long age) {
        String message = "Name: " + name + ", Area: " + area + ", Age: " + age;
        kafkaTemplate.send("person-topic",message);

    }
}
