package com.gia.gestion_reservas_hotel.services.implement;

import com.gia.gestion_reservas_hotel.models.Role;
import com.gia.gestion_reservas_hotel.repositories.RoleRepository;
import com.gia.gestion_reservas_hotel.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role crearRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> obtenerTodosLosRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role obtenerRolePorId(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role obtenerRolePorNombre(String nombre) {
        return roleRepository.findByName(nombre);
    }

    @Override
    public void eliminarRole(Long id) {
        roleRepository.deleteById(id);
    }
}

