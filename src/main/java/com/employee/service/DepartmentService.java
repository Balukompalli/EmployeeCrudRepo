package com.employee.service;

import com.employee.Model.Department;
import com.employee.Model.Employee;
import com.employee.dao.DepartmentRepository;
import com.employee.dao.EmployeeRepository;
import com.employee.exception.MyDatabaseException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentService {

    EmployeeService employeeService;

    DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, EmployeeService employeeService) {
        this.departmentRepository = departmentRepository;
        this.employeeService = employeeService;
    }


    public Department saveDepartment(Department department) throws Exception {
        if(department.getDepartmentName().length() < 3)
            throw new MyDatabaseException("Department name should be minimum 3 letters");
        return departmentRepository.save(department);
    }


    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }


    public Optional<Department> getDepartmentByDepartmentId(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }

    private Employee apply(Employee employee) {
        try {
            return employeeService.saveEmployee(employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
