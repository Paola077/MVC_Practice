package org.f5.veterinaria.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GuardianNotFoundExcepcion extends RuntimeException {

    public GuardianNotFoundExcepcion(String message) {
        super(message);
    }
}
