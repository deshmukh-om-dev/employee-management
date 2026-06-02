package com.employee.employee_management.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice //global exception handler for all controllers
public class GlobalExceptionHandler {
    @ExceptionHandler(
            MethodArgumentNotValidException.class) //handles all validation errors
    @ResponseStatus(HttpStatus.BAD_REQUEST) //is used to return proper HTTP status code 400 when validation exception occurs
    public Map<String, String> handleValidationExceptions( //mapm cretaed to store
            MethodArgumentNotValidException ex) {
        Map<String, String> errors =
                new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> {
                    errors.put(
                            error.getField(),
                            error.getDefaultMessage()); //gets customized message
                });
        return errors;
    }
}