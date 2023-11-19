package com.employee.service;

import com.employee.Model.Department;
import com.employee.Model.Employee;
import com.employee.dao.DepartmentRepository;
import com.employee.exception.MyDatabaseException;
import com.employee.dao.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    DepartmentService departmentService;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,
                           @Lazy DepartmentService departmentService) {
        this.employeeRepository = employeeRepository;
        this.departmentService = departmentService;
    }


    public Employee saveEmployee(Employee employee) throws Exception {
        if (employee.getEmployeeName().length() < 3)
            throw new MyDatabaseException("Employee name should be minimum 3 letters");
        employee.setDepartment(departmentService.saveDepartment(employee.getDepartment()));
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }


    public Optional<Employee> getEmployeeByEmployeeId(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

}
