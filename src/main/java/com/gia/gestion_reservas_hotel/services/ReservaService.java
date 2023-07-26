package com.gia.gestion_reservas_hotel.services;

import com.gia.gestion_reservas_hotel.models.Hotel;
import com.gia.gestion_reservas_hotel.models.Reserva;
import com.gia.gestion_reservas_hotel.models.User;

import java.util.List;

public interface ReservaService {

    Reserva crearReserva(Reserva reserva);

    List<Reserva> obtenerTodasLasReservas();

    Reserva obtenerReservaPorId(Long id);

    Reserva actualizarReserva(Reserva reserva);

    void eliminarReserva(Long id);

    Hotel obtenerHotelPorId(Long hotelId);

    User obtenerUsuarioPorId(Long usuarioId);
}


