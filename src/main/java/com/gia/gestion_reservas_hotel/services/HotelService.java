package com.gia.gestion_reservas_hotel.services;

import com.gia.gestion_reservas_hotel.models.Hotel;

import java.time.LocalDate;
import java.util.List;

public interface HotelService {
    List<Hotel> obtenerTodosLosHoteles();

    Hotel obtenerHotelPorId(Long id);

    List<Hotel> obtenerHotelesPorNombre(String nombre);

    List<Hotel> obtenerHotelesPorCapacidad(int capacidad);

    List<Hotel> obtenerHotelesPorNumeroDeHabitaciones(int numeroHabitaciones);

    List<Hotel> obtenerHotelesDisponiblesEnRangoDeFechas(LocalDate fechaInicio, LocalDate fechaFin);

    Hotel crearHotel(Hotel hotel);

    Hotel actualizarHotel(Hotel hotel);

    void eliminarHotel(Long id);
}

