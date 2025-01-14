package com.coaching.center.exception;

public class DuplicateStudentException extends RuntimeException{
    public DuplicateStudentException(String message) {
        super(message);
    }
    public DuplicateStudentException(String email, String contactNumber) {
        super("A student with email " + email + " or contact number " + contactNumber + " already exists.");
    }
}
