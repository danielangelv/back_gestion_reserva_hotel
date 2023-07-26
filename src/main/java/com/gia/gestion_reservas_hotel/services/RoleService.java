package com.gia.gestion_reservas_hotel.services;

import com.gia.gestion_reservas_hotel.models.Role;

import java.util.List;

public interface RoleService {

    Role crearRole(Role role);

    List<Role> obtenerTodosLosRoles();

    Role obtenerRolePorId(Long id);

    Role obtenerRolePorNombre(String nombre);

    void eliminarRole(Long id);
}

