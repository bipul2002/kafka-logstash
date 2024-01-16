package com.kafka.kafka.service;

import com.kafka.kafka.entity.Person;

public interface PersonService {
    Person findById(Long id);

    void createPerson(Person person);

    void deletePersonById(Long id);
}

