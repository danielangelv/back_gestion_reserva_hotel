package com.gia.gestion_reservas_hotel.services;

import com.gia.gestion_reservas_hotel.models.User;

import java.util.List;

public interface UserService {
    User registrarUsuario(User user);
    List<User> obtenerTodosLosUsuarios();
    User obtenerUsuarioPorId(Long id);
    User actualizarUsuario(User user);
    void eliminarUsuario(Long id);

    boolean existeUsuarioPorCorreo(String correo);
}
