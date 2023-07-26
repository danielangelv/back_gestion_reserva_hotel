package com.gia.gestion_reservas_hotel.exceptions;

public class HotelNameAlreadyExistsException extends RuntimeException {

    public HotelNameAlreadyExistsException(String message) {
        super(message);
    }
}
