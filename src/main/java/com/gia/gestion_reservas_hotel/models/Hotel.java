package com.gia.gestion_reservas_hotel.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int capacidadDeReservas;
    private String telefono;
    private String direccion;
    private String correo;
    private int numeroDeHabitaciones;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas = new ArrayList<>();

    // Constructor, getters y setters

    // Constructor vacío
    public Hotel() {
    }

    // Constructor con todos los atributos
    public Hotel(String nombre, int capacidadDeReservas, String telefono, String direccion, String correo, int numeroDeHabitaciones) {
        this.nombre = nombre;
        this.capacidadDeReservas = capacidadDeReservas;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.numeroDeHabitaciones = numeroDeHabitaciones;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidadDeReservas() {
        return capacidadDeReservas;
    }

    public void setCapacidadDeReservas(int capacidadDeReservas) {
        this.capacidadDeReservas = capacidadDeReservas;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNumeroDeHabitaciones() {
        return numeroDeHabitaciones;
    }

    public void setNumeroDeHabitaciones(int numeroDeHabitaciones) {
        this.numeroDeHabitaciones = numeroDeHabitaciones;
    }

    // Métodos adicionales para gestionar las reservas en este hotel

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
        reserva.setHotel(this);
    }

    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
        reserva.setHotel(null);
    }

}


