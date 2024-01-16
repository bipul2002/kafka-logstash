package com.kafka.kafka.serviceiImpl;

import com.kafka.kafka.entity.Person;
import com.kafka.kafka.repo.PersonRepository;
import com.kafka.kafka.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    private KafkaProducerServiceImpl kafkaProducerService;
    @Override
    public Person findById(Long id) {
        return personRepository.findByPersonId(id);
    }

    @Override
    public void createPerson(Person person) {
        Person savedPerson   = personRepository.save(person);

        kafkaProducerService.sendPersonData(savedPerson.getName(), savedPerson.getAddress(), savedPerson.getAge());

    }

    @Override
    public void deletePersonById(Long id) {
        Person person = personRepository.findByPersonId(id);
        if (person != null) {
            personRepository.deleteById(id);

        }else {
            System.out.println("Person with the above Id is not available");
        }

    }
}
