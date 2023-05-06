package com.geekster.Employee_Address_Assignment.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.engine.internal.Cascade;

@Data
@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
