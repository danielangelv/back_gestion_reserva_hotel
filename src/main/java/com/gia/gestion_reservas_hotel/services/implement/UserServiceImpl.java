package com.gia.gestion_reservas_hotel.services.implement;

import com.gia.gestion_reservas_hotel.models.User;
import com.gia.gestion_reservas_hotel.repositories.UserRepository;
import com.gia.gestion_reservas_hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registrarUsuario(User user) {
        // Puedes realizar validaciones adicionales antes de guardar el usuario en la base de datos
        return userRepository.save(user);
    }

    @Override
    public List<User> obtenerTodosLosUsuarios() {
        return userRepository.findAll();
    }

    @Override
    public User obtenerUsuarioPorId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User actualizarUsuario(User user) {
        // Puedes realizar validaciones y lógica de actualización antes de guardar los cambios
        return userRepository.save(user);
    }

    @Override
    public void eliminarUsuario(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean existeUsuarioPorCorreo(String correo) {
        User user = userRepository.findByCorreo(correo);
        return user != null;
    }
}

