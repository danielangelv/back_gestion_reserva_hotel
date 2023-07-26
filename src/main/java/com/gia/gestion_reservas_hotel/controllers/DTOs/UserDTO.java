package com.gia.gestion_reservas_hotel.controllers.DTOs;


public class UserDTO {
    private String nombre;
    private String telefono;
    private String documento;
    private String tipoDocumento;
    private String password;
    private String correo;

    // Constructor vacío
    public UserDTO() {
    }

    // Constructor con todos los campos
    public UserDTO(String nombre, String telefono, String documento, String tipoDocumento, String password, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
        this.password = password;
        this.correo = correo;
    }

    // Getters y setters para todos los campos
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}

