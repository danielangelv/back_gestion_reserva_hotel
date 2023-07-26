package com.gia.gestion_reservas_hotel.controllers;

import com.gia.gestion_reservas_hotel.models.Hotel;
import com.gia.gestion_reservas_hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoteles")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> obtenerHoteles() {
        List<Hotel> hoteles = hotelService.obtenerTodosLosHoteles();
        return ResponseEntity.ok(hoteles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> obtenerHotelPorId(@PathVariable Long id) {
        Hotel hotel = hotelService.obtenerHotelPorId(id);
        return hotel != null
                ? ResponseEntity.ok(hotel)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Hotel> crearHotel(@RequestBody Hotel hotel) {
        // Validaciones básicas
        if (hotel.getNombre() == null || hotel.getNombre().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        if (hotel.getCapacidadDeReservas() <= 0) {
            return ResponseEntity.badRequest().body(null);
        }

        if (hotel.getCorreo() == null || !isValidEmail(hotel.getCorreo())) {
            return ResponseEntity.badRequest().body(null);
        }

        Hotel nuevoHotel = hotelService.crearHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoHotel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> actualizarHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        // Validaciones básicas
        if (hotel.getNombre() == null || hotel.getNombre().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        if (hotel.getCapacidadDeReservas() <= 0) {
            return ResponseEntity.badRequest().body(null);
        }

        if (hotel.getCorreo() == null || !isValidEmail(hotel.getCorreo())) {
            return ResponseEntity.badRequest().body(null);
        }

        Hotel hotelExistente = hotelService.obtenerHotelPorId(id);
        if (hotelExistente != null) {
            hotel.setId(id);
            Hotel hotelActualizado = hotelService.actualizarHotel(hotel);
            return ResponseEntity.ok(hotelActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHotel(@PathVariable Long id) {
        Hotel hotelExistente = hotelService.obtenerHotelPorId(id);
        if (hotelExistente != null) {
            hotelService.eliminarHotel(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Método auxiliar para validar el formato del correo electrónico
    private boolean isValidEmail(String email) {
        // Implementar la lógica de validación del correo electrónico aquí
        // Por simplicidad, asumiremos que cualquier cadena que contenga un @ es válida
        return email.contains("@");
    }
}

