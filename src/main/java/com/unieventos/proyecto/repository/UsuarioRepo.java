package com.unieventos.proyecto.repository;

import com.unieventos.proyecto.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepo extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByEmail(String email);
}
