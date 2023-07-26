package com.gia.gestion_reservas_hotel.repositories;

import com.gia.gestion_reservas_hotel.models.Hotel;
import com.gia.gestion_reservas_hotel.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Consulta para obtener un usuario por su documento y tipo de documento
    User findByDocumentoAndTipoDocumento(String documento, String tipoDocumento);

    // Consulta para obtener todos los usuarios que contengan un nombre específico
    List<User> findByNombreContaining(String nombre);

    // Consulta para obtener todos los usuarios que tengan una reserva en un hotel específico
    List<User> findByReservasHotel(Hotel hotel); // Cambiado el nombre del método

    // Consulta para obtener un usuario por su nombre de usuario (correo electrónico)
    User findByNombre(String nombre);

    // Consulta para obtener un usuario por su dirección de correo electrónico
    User findByCorreo(String correo);
}



