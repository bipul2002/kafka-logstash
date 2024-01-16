package com.kafka.kafka.controller;

import com.kafka.kafka.entity.Person;
import com.kafka.kafka.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/{personId}")
    public Person findPersonById(@PathVariable("personId") Long id)
    {
        return personService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<String> addUser(@RequestBody Person tempPerson) throws Exception{
        this.personService.createPerson(tempPerson);
        return ResponseEntity.ok("A new person is successfully added!!");
    }


    @DeleteMapping("/{personId}")
    public ResponseEntity<String> deletePerson(@PathVariable("personId") Long id)
    {
        Person person = personService.findById(id);
        if(person!=null)
        {
            personService.deletePersonById(id);
            return  ResponseEntity.ok("Person is deleted Successfully");
        }
        return  ResponseEntity.ok("Person with the above Id is Not found!!");
    }

}
