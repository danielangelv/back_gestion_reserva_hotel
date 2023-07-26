package com.gia.gestion_reservas_hotel.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoDeHabilitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToMany
    @JoinTable(
            name = "reserva_usuario",
            joinColumns = @JoinColumn(name = "reserva_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<User> clientes = new ArrayList<>();

    public Reserva() {
        // Constructor vacío
    }

    public Reserva(String codigoDeHabilitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.codigoDeHabilitacion = codigoDeHabilitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoDeHabilitacion() {
        return codigoDeHabilitacion;
    }

    public void setCodigoDeHabilitacion(String codigoDeHabilitacion) {
        this.codigoDeHabilitacion = codigoDeHabilitacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<User> getClientes() {
        return clientes;
    }

    public void agregarCliente(User cliente) {
        clientes.add(cliente);
        cliente.getReservas().add(this);
    }

    public void eliminarCliente(User cliente) {
        clientes.remove(cliente);
        cliente.getReservas().remove(this);
    }

}


