package com.gia.gestion_reservas_hotel.repositories;

import com.gia.gestion_reservas_hotel.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // Consulta para obtener hoteles por nombre
    List<Hotel> findByNombreContainingIgnoreCase(String nombre);

    // Consulta para obtener hoteles por capacidad de reservas
    List<Hotel> findByCapacidadDeReservasGreaterThanEqual(int capacidad);

    // Consulta para obtener hoteles por número de habitaciones
    List<Hotel> findByNumeroDeHabitacionesGreaterThanEqual(int numeroHabitaciones);

    // Consulta para obtener hoteles por disponibilidad de habitaciones en un rango de fechas
    @Query("SELECT h FROM Hotel h WHERE h.id NOT IN " +
            "(SELECT r.hotel.id FROM Reserva r " +
            "WHERE (:fechaInicio BETWEEN r.fechaInicio AND r.fechaFin) " +
            "OR (:fechaFin BETWEEN r.fechaInicio AND r.fechaFin))")
    List<Hotel> findHotelesDisponiblesEnRangoDeFechas(@Param("fechaInicio") LocalDate fechaInicio,
                                                      @Param("fechaFin") LocalDate fechaFin);
}

