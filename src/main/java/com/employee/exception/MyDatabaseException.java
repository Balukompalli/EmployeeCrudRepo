package com.employee.exception;

public class MyDatabaseException extends RuntimeException {
    public MyDatabaseException(String message) {
        super(message);
    }
}
