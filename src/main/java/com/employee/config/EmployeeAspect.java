package com.employee.config;

import com.employee.Model.Employee;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class EmployeeAspect {

    @Before(value ="execution(* com.employee.Controller.EmployeeController.*(..))")
    public void beforeGetAllEmployees(JoinPoint joinPoint) {
        log.info("@Before EmployeeController started for method :"+joinPoint.getSignature()+" and time :"+ LocalDateTime.now());
    }

    @After(value ="execution(* com.employee.Controller.EmployeeController.*(..))")
    public void afterGetAllEmployees(JoinPoint joinPoint) {
        log.info("@After EmployeeController completed for method :"+joinPoint.getSignature()+" and time :"+ LocalDateTime.now());
    }

    @Before(value ="execution(* com.employee.service.EmployeeService.saveEmployee(..))")
    public void beforeEmployeeService_SaveEmployee(JoinPoint joinPoint) {
        log.info("@Before EmployeeService started for method :"+joinPoint.getSignature()+" and time :"+ LocalDateTime.now());
    }

    @After(value ="execution(* com.employee.service.EmployeeService.saveEmployee(..))")
    public void afterEmployeeService_SaveEmployee(JoinPoint joinPoint) {
        log.info(" @After EmployeeService completed for method :"+joinPoint.getSignature()+" and time :"+ LocalDateTime.now());
    }

    @AfterReturning(value = "execution(* com.employee.service.EmployeeService.saveEmployee(..))" , returning = "employee")
    public void afterReturningSaveEmployee(JoinPoint joinPoint, Employee employee) {
        log.info("@AfterReturning for method :"+joinPoint.getSignature()+" and time :"
                + LocalDateTime.now()+" with employee Id: "+employee.getEmployeeId());
    }


    @AfterThrowing(value = "execution(* com.employee.service.EmployeeService.saveEmployee(..))", throwing = "exception")
    public void afterThrowingSaveEmployee(JoinPoint joinPoint, Exception exception) {
        log.info("@AfterThrowing started for method :"+joinPoint.getSignature()+" and time :"+ LocalDateTime.now()+
                " with employee Id: "+ exception.getMessage());
    }

    @Around(value ="execution(* com.employee.service.EmployeeService.saveEmployee(..))")
    public Employee aroundSaveEmployee(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("@Around on EmployeeService :  started for method :"+proceedingJoinPoint.getSignature()+" and time :"+ LocalDateTime.now());

        try {
            Employee employee = Employee.builder()
                    .employeeName("dummy")
                    .departmentName("qa")
                    .salary(10000L)
                    .build();
            Employee[] dummyEmployees = new Employee[1]; //Aspect has the power to change the employeeName instead of request's employee name
            dummyEmployees[0] =employee;
            return (Employee) proceedingJoinPoint.proceed(dummyEmployees);
//            proceedingJoinPoint.proceed();
//            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            log.info("@Around on EmployeeService catch : failed to save the data for method :"+proceedingJoinPoint.getSignature()+" and time :"+ LocalDateTime.now());
                //throw new MyDatabaseException(throwable.getMessage());
        }
        return null;
    }
}
