package org.andarworld.maineducationservice.api.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UniversityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse universityNotFound(UniversityNotFoundException e) {
        return new ErrorResponse(e.getMessage(), 400, new Date().toString());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse stringUuidTooLongOrShort(ConstraintViolationException e) {
        return new ErrorResponse(e.getMessage(), 400, new Date().toString());
    }
}
