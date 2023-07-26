package com.gia.gestion_reservas_hotel.repositories;

import com.gia.gestion_reservas_hotel.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String nombre);

}

