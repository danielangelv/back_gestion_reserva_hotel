package com.gia.gestion_reservas_hotel.controllers.DTOs;

import java.time.LocalDate;

public class ReservaDTO {
    private String codigoDeHabilitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Long hotelId;
    private Long usuarioId;

    public ReservaDTO() {
        // Constructor vacío
    }

    public ReservaDTO(String codigoDeHabilitacion, LocalDate fechaInicio, LocalDate fechaFin, Long hotelId, Long usuarioId) {
        this.codigoDeHabilitacion = codigoDeHabilitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.hotelId = hotelId;
        this.usuarioId = usuarioId;
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

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}

