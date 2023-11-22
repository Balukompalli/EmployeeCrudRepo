package com.employee.Controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee) throws Exception {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/getEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/getEmployeeById")
    public Employee getEmployeeById(@RequestParam(name = "employeeId") Long employeeId) {
        return employeeService.getEmployeeByEmployeeId(employeeId).get();
    }

}
