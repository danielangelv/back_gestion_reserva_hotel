package com.gia.gestion_reservas_hotel.repositories;

import com.gia.gestion_reservas_hotel.models.Hotel;
import com.gia.gestion_reservas_hotel.models.Reserva;
import com.gia.gestion_reservas_hotel.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByHotelAndFechaInicioGreaterThanEqualAndFechaFinLessThanEqual(Hotel hotel, LocalDate fechaInicio, LocalDate fechaFin);

    List<Reserva> findByHotelAndFechaFinGreaterThanEqual(Hotel hotel, LocalDate fechaFin);

    List<Reserva> findByHotelAndFechaInicioLessThanEqual(Hotel hotel, LocalDate fechaInicio);

    List<Reserva> findByFechaInicioGreaterThanEqualAndFechaFinLessThanEqual(LocalDate fechaInicio, LocalDate fechaFin);
}

