package com.proyecto.reposteria.servlet;

import com.proyecto.reposteria.dto.Respuesta;
import com.proyecto.reposteria.exception.ServiceException;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Locale;

@RequiredArgsConstructor
@RestControllerAdvice
public class ExceptionHandlerController {

    private final MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Respuesta constraintsValidationHandler(ConstraintViolationException e, Locale locale) {

        List<String> errors = e.getConstraintViolations().stream()
                .map(constraintViolation -> constraintViolation.getMessage()).toList();

        return Respuesta.builder()
                .mensaje(this.messageSource.getMessage("global.error.found", null, locale))
                .errores(errors)
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Respuesta methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e, Locale locale) {

        List<String> errors = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getDefaultMessage()).toList();

        return Respuesta.builder()
                .mensaje(this.messageSource.getMessage("global.error.found", null, locale))
                .errores(errors)
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ServiceException.class)
    public Respuesta serviceExceptionHandler(ServiceException e) {
        return Respuesta.builder()
                .mensaje(e.getMessage())
                .build();
    }

    @ExceptionHandler({AuthenticationException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Respuesta handleAuthenticationException(Exception ex, Locale locale) {
        return Respuesta.builder()
                .mensaje(this.messageSource.getMessage("login.error", null, locale))
                .build();
    }

}
