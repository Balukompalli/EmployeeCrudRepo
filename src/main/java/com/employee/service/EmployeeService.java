package com.employee.service;

import com.employee.Model.Employee;
import com.employee.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return  employeeRepository.save(employee);
    }


    public List<Employee> getAllEmployee() {
        return  employeeRepository.findAll();
    }


    public Optional<Employee> getEmployeeByEmployeeId(Long employeeId) {
        return  employeeRepository.findById(employeeId);
    }


}
