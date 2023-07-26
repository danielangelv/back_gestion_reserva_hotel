package com.gia.gestion_reservas_hotel.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String telefono;

    @Column(unique = true)
    private String correo;

    private String documento;
    private String tipoDocumento;

    @ManyToMany(mappedBy = "clientes")
    private List<Reserva> reservas;
    private String password;

    // Constructor, getters y setters

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    // Constructor vacío
    public User() {
        reservas = new ArrayList<>();
    }

    public User(String nombre, String telefono, String correo, String documento, String tipoDocumento) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
        reservas = new ArrayList<>();
    }

    // Getters y setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(correo, user.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correo);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
        reserva.getClientes().add(this);
    }

    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
        reserva.getClientes().remove(this);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

}



