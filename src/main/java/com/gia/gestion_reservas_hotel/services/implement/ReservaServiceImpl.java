package com.gia.gestion_reservas_hotel.services.implement;

import com.gia.gestion_reservas_hotel.exceptions.ReservaNotFoundException;
import com.gia.gestion_reservas_hotel.models.Hotel;
import com.gia.gestion_reservas_hotel.models.Reserva;
import com.gia.gestion_reservas_hotel.models.User;
import com.gia.gestion_reservas_hotel.repositories.ReservaRepository;
import com.gia.gestion_reservas_hotel.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gia.gestion_reservas_hotel.repositories.HotelRepository;
import com.gia.gestion_reservas_hotel.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final HotelRepository hotelRepository;
    private final UserRepository userRepository;

    @Autowired
    public ReservaServiceImpl(ReservaRepository reservaRepository, HotelRepository hotelRepository, UserRepository userRepository) {
        this.reservaRepository = reservaRepository;
        this.hotelRepository = hotelRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Reserva crearReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva obtenerReservaPorId(Long id) {
        Optional<Reserva> optionalReserva = reservaRepository.findById(id);
        return optionalReserva.orElseThrow(() -> new ReservaNotFoundException("Reserva no encontrada con el ID: " + id));
    }

    @Override
    public Reserva actualizarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public void eliminarReserva(Long id) {
        reservaRepository.deleteById(id);
    }

    @Override
    public Hotel obtenerHotelPorId(Long hotelId) {
        // Implementar lógica para obtener el hotel desde la base de datos
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
        return optionalHotel.orElse(null);
    }

    @Override
    public User obtenerUsuarioPorId(Long usuarioId) {
        // Implementar lógica para obtener el usuario desde la base de datos
        Optional<User> optionalUser = userRepository.findById(usuarioId);
        return optionalUser.orElse(null);
    }
}

