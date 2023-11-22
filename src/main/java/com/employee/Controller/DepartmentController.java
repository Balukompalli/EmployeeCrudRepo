package com.employee.Controller;

import com.employee.entity.Department;
import com.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {

    DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/saveDepartment")
    public Department saveDepartment(@RequestBody Department department) throws Exception {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/getDepartments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/getDepartmentById")
    public Department getDepartmentById(@RequestParam(name = "departmentId") Long departmentId) {
        return departmentService.getDepartmentByDepartmentId(departmentId).get();
    }

}
