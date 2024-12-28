package com.coaching.center.exception;

import java.util.List;

public class MissingMandatoryFieldException extends RuntimeException {

    private final List<String> errors;
    public MissingMandatoryFieldException(String message, List<String> errors){
        super(message);
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
