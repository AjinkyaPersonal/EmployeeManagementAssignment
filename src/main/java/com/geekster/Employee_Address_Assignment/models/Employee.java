package com.geekster.Employee_Address_Assignment.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
