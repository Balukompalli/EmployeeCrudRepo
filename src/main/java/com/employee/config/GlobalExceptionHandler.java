package com.employee.config;


import org.springframework.boot.context.config.InactiveConfigDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.ConnectException;
import java.sql.SQLSyntaxErrorException;
import java.util.logging.Logger;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = Logger.getLogger(String.valueOf(GlobalExceptionHandler.class));

    @ExceptionHandler(MyDatabaseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String  handleDataBaseServerException(MyDatabaseException connectException) {
        logger.info(connectException.getLocalizedMessage());
        return "Database is not up & running";
    }

    @ExceptionHandler(InactiveConfigDataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String  handleDataBaseServerException(InactiveConfigDataAccessException inactiveConfigDataAccessException) {
        logger.info(inactiveConfigDataAccessException.getLocalizedMessage());
        return "Database is not up & running";
    }

}
