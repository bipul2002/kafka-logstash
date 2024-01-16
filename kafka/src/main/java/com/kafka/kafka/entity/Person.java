package com.kafka.kafka.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "dob")
    private Date dob;
}
