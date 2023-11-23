package com.employee.Controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

//    @GetMapping("/getEmployeeById")
//    public ResponseEntity<Employee> getEmployeeById(@RequestParam(name = "employeeId") Long employeeId) {
//         Optional<Employee> optionalEmployee = employeeService.getEmployeeByEmployeeId(employeeId);
//            if(!optionalEmployee.isEmpty()) {
//                //optionalEmployee.get().setEmployeeName(null);
//                Optional<String> employeeName = Optional.ofNullable(optionalEmployee.get().getEmployeeName());
//
////                optionalEmployee.get().setEmployeeName(null);
////                Optional<String> employeeName = Optional.of(optionalEmployee.get().getEmployeeName());
//
////                if(optionalEmployee.isPresent()) {
////                    System.out.println(employeeName.get().toUpperCase());
////                }else {
////                    System.out.println("Name is null");
////                }
//                employeeName.ifPresentOrElse(s -> System.out.println("name: "+s),() -> System.out.println("name is not present"));
//
//                //String employeeName = Optional.ofNullable(optionalEmployee.get().getEmployeeName()).orElse("default_user");
////                String employeeName = Optional.ofNullable(optionalEmployee.get().getEmployeeName()).orElseGet(
////                        () -> {
////                            return String.valueOf(Employee.builder()
////                        .employeeName("default_user").build());
////                        });
//
//                //String employeeName = Optional.ofNullable(optionalEmployee.get().getEmployeeName()).orElseThrow(() -> new IllegalArgumentException("No name is available"));
//                System.out.println("emplyee name :: "+employeeName);
//            return ResponseEntity.status(HttpStatus.OK).body(optionalEmployee.get());
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Employee.builder().employeeName("employee not found").build());
//            }
//    }

}
