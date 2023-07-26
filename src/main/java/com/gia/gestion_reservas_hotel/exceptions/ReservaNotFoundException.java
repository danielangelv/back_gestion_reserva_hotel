package com.gia.gestion_reservas_hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReservaNotFoundException extends RuntimeException {

    public ReservaNotFoundException(String message) {
        super(message);
    }
}

