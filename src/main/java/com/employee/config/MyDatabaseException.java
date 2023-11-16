package com.employee.config;

public class MyDatabaseException extends RuntimeException {
    public MyDatabaseException(String message) {
        super(message);
    }
}
