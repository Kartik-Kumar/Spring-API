package com.basicrestapi.springbootrestcontrollerlearning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class to handle exceptions thrown by controller
 */
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void carNotFound() { }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Wrong input path variable")
    public List<String> wrongInputPathVariableRequestParam(ConstraintViolationException exception) {
        return exception.getConstraintViolations()
                .stream()
                .map(constraintViolation -> constraintViolation.getMessage())
                .toList();
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public List<String> wrongInputRequestBody(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .toList();
    }
}
