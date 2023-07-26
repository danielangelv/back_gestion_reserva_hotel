package com.gia.gestion_reservas_hotel.controllers;

import com.gia.gestion_reservas_hotel.controllers.DTOs.UserDTO;
import com.gia.gestion_reservas_hotel.models.User;
import com.gia.gestion_reservas_hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registro")
    public ResponseEntity<String> registrarUsuario(@RequestBody UserDTO userDTO) {
        try {
            // Validar que no exista un usuario con el mismo correo
            if (userService.existeUsuarioPorCorreo(userDTO.getCorreo())) {
                return ResponseEntity.badRequest().body("Ya existe un usuario registrado con el mismo correo.");
            }

            // Crear un nuevo objeto User con los datos del formulario
            User newUser = new User();
            newUser.setNombre(userDTO.getNombre());
            newUser.setTelefono(userDTO.getTelefono());
            newUser.setDocumento(userDTO.getDocumento());
            newUser.setTipoDocumento(userDTO.getTipoDocumento());

            // Guardar el usuario en la base de datos a través del servicio
            User savedUser = userService.registrarUsuario(newUser);

            return ResponseEntity.ok("Usuario registrado exitosamente.");
        } catch (Exception e) {
            // Manejar las excepciones y devolver una respuesta adecuada en caso de error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el usuario.");
        }
    }
}

