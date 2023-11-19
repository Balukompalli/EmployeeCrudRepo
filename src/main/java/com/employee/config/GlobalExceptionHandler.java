package com.employee.config;


import com.employee.exception.MyDatabaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.config.InactiveConfigDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(MyDatabaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String  handleDataBaseServerException(MyDatabaseException myDatabaseException) {
        log.info(myDatabaseException.getMessage());
        return "Database is not up & running";
    }

    @ExceptionHandler(InactiveConfigDataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String  handleDataBaseServerException(InactiveConfigDataAccessException inactiveConfigDataAccessException) {
        log.info(inactiveConfigDataAccessException.getLocalizedMessage());
        return "Database is not up & running";
    }

}
