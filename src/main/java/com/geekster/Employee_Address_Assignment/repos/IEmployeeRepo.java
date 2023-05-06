package com.geekster.Employee_Address_Assignment.repos;

import com.geekster.Employee_Address_Assignment.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee , Long> {
}
