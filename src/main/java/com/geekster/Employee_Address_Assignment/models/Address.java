package com.geekster.Employee_Address_Assignment.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String street;
    private String city;
    private String state;
    private String zipcode;
}
