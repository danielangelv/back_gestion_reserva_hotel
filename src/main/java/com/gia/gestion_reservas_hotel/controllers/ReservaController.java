package com.gia.gestion_reservas_hotel.controllers;

import com.gia.gestion_reservas_hotel.controllers.DTOs.ReservaDTO;
import com.gia.gestion_reservas_hotel.models.Hotel;
import com.gia.gestion_reservas_hotel.models.Reserva;
import com.gia.gestion_reservas_hotel.models.User;
import com.gia.gestion_reservas_hotel.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    // Obtener todas las reservas
    @GetMapping
    public ResponseEntity<List<Reserva>> obtenerReservas() {
        List<Reserva> reservas = reservaService.obtenerTodasLasReservas();
        return ResponseEntity.ok(reservas);
    }

    // Obtener una reserva por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtenerReservaPorId(@PathVariable Long id) {
        Reserva reserva = reservaService.obtenerReservaPorId(id);
        if (reserva != null) {
            return ResponseEntity.ok(reserva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear una nueva reserva
    @PostMapping
    public ResponseEntity<Object> crearReserva(@RequestBody ReservaDTO reservaDTO) {
        try {
            // Validar los datos recibidos
            if (reservaDTO.getCodigoDeHabilitacion() == null || reservaDTO.getCodigoDeHabilitacion().isEmpty()) {
                return ResponseEntity.badRequest().body("El código de habilitación no puede estar vacío.");
            }

            if (reservaDTO.getFechaInicio() == null || reservaDTO.getFechaFin() == null ||
                    reservaDTO.getFechaInicio().isAfter(reservaDTO.getFechaFin())) {
                return ResponseEntity.badRequest().body("Las fechas de inicio y fin de la reserva son inválidas.");
            }

            // Obtener el hotel y el usuario correspondiente a partir de los IDs
            Hotel hotel = reservaService.obtenerHotelPorId(reservaDTO.getHotelId());
            User usuario = reservaService.obtenerUsuarioPorId(reservaDTO.getUsuarioId());

            if (hotel == null || usuario == null) {
                return ResponseEntity.badRequest().body("Hotel o usuario no encontrados.");
            }

            // Crear una nueva reserva y asociarla al hotel y usuario
            Reserva nuevaReserva = new Reserva(reservaDTO.getCodigoDeHabilitacion(),
                    reservaDTO.getFechaInicio(), reservaDTO.getFechaFin());
            nuevaReserva.setHotel(hotel);
            nuevaReserva.agregarCliente(usuario);

            // Guardar la reserva en la base de datos a través del servicio
            Reserva reservaGuardada = reservaService.crearReserva(nuevaReserva);

            return ResponseEntity.status(HttpStatus.CREATED).body(reservaGuardada);
        } catch (Exception e) {
            // Manejar las excepciones y devolver una respuesta adecuada en caso de error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la reserva.");
        }
    }

    // Actualizar una reserva existente por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> actualizarReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        Reserva reservaExistente = reservaService.obtenerReservaPorId(id);
        if (reservaExistente != null) {
            reserva.setId(id); // Asegurarse de que el ID de la reserva coincida con el ID de la solicitud
            Reserva reservaActualizada = reservaService.actualizarReserva(reserva);
            return ResponseEntity.ok(reservaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una reserva por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Long id) {
        Reserva reservaExistente = reservaService.obtenerReservaPorId(id);
        if (reservaExistente != null) {
            reservaService.eliminarReserva(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

