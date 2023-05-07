package com.geekster.Employee_Address_Assignment.services;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.geekster.Employee_Address_Assignment.models.Employee;
import com.geekster.Employee_Address_Assignment.repos.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepo employeeRepo;

    public String addEmployees(List<Employee> employeeList) {
        List<Employee> employeeList1 = employeeRepo.saveAll(employeeList);

        if(employeeList1==null){
            return "Not added successfully";
        }

        return "Added successfully";
    }

    public List<Employee> getEmployees(Long employeeId) {
        if(employeeId == null){
            return employeeRepo.findAll();
        }else{
            List<Employee> employeeList = new ArrayList<>();
            Optional<Employee> list = employeeRepo.findById(employeeId);
            if(list.isEmpty()){
                throw new IllegalStateException("employeeId not found");
            }
            employeeList.add(employeeRepo.findById(employeeId).get());
            return employeeList;

        }

    }

    public String deleteEmployee(Long employeeId) {
        Optional<Employee> list = employeeRepo.findById(employeeId);

        if(list.isEmpty()){
            return "Employee with employeeId "+ employeeId + " not found";
        }else{
            employeeRepo.deleteById(employeeId);
            return "Employee with employeeId "+ employeeId + " deleted successfully";
        }
    }

    public String updateEmployee(Long employeeId, Employee employee) {
        Optional<Employee> list = employeeRepo.findById(employeeId);
        employee.setEmployeeId(employeeId);

        if(list.isEmpty()){
            return "Employee with employeeId "+ employeeId + " not found";
        }else{
            employeeRepo.save(employee);
            return "Employee with employeeId "+ employeeId + " updated successfully";
        }
    }
}
