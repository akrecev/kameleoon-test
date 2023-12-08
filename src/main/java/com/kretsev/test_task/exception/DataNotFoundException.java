package com.kretsev.test_task.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(String data, Long id) {
        super(data + " with id=" + id + " was not found");
    }
}
