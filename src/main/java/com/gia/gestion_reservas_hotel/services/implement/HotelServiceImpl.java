package com.gia.gestion_reservas_hotel.services.implement;

import com.gia.gestion_reservas_hotel.exceptions.HotelNameAlreadyExistsException;
import com.gia.gestion_reservas_hotel.exceptions.HotelNotFoundException;
import com.gia.gestion_reservas_hotel.models.Hotel;
import com.gia.gestion_reservas_hotel.repositories.HotelRepository;
import com.gia.gestion_reservas_hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> obtenerTodosLosHoteles() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel obtenerHotelPorId(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException("Hotel con ID " + id + " no encontrado"));
    }

    @Override
    public List<Hotel> obtenerHotelesPorNombre(String nombre) {
        return hotelRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Hotel> obtenerHotelesPorCapacidad(int capacidad) {
        return hotelRepository.findByCapacidadDeReservasGreaterThanEqual(capacidad);
    }

    @Override
    public List<Hotel> obtenerHotelesPorNumeroDeHabitaciones(int numeroHabitaciones) {
        return hotelRepository.findByNumeroDeHabitacionesGreaterThanEqual(numeroHabitaciones);
    }

    @Override
    public List<Hotel> obtenerHotelesDisponiblesEnRangoDeFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return hotelRepository.findHotelesDisponiblesEnRangoDeFechas(fechaInicio, fechaFin);
    }

    @Override
    public Hotel crearHotel(Hotel hotel) {
        // Validación de restricciones
        List<Hotel> hotelesConMismoNombre = hotelRepository.findByNombreContainingIgnoreCase(hotel.getNombre());
        if (!hotelesConMismoNombre.isEmpty()) {
            throw new HotelNameAlreadyExistsException("Ya existe un hotel con el mismo nombre");
        }

        // Otras validaciones según tus requerimientos

        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel actualizarHotel(Hotel hotel) {
        // Validar que el hotel exista
        if (!hotelRepository.existsById(hotel.getId())) {
            throw new HotelNotFoundException("Hotel con ID " + hotel.getId() + " no encontrado");
        }

        // Validación de restricciones al actualizar el hotel
        List<Hotel> hotelesConMismoNombre = hotelRepository.findByNombreContainingIgnoreCase(hotel.getNombre());
        for (Hotel h : hotelesConMismoNombre) {
            if (!h.getId().equals(hotel.getId())) {
                throw new HotelNameAlreadyExistsException("Ya existe otro hotel con el mismo nombre");
            }
        }

        // Otras validaciones según tus requerimientos

        return hotelRepository.save(hotel);
    }

    @Override
    public void eliminarHotel(Long id) {
        // Verificar si el hotel existe antes de eliminarlo
        if (!hotelRepository.existsById(id)) {
            throw new HotelNotFoundException("Hotel con ID " + id + " no encontrado");
        }

        // Otras validaciones según tus requerimientos

        hotelRepository.deleteById(id);
    }
}


