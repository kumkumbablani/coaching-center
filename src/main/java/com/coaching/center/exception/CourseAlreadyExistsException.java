package com.coaching.center.exception;

public class CourseAlreadyExistsException extends RuntimeException {
    public CourseAlreadyExistsException(String message){
        super(message);
    }
}
