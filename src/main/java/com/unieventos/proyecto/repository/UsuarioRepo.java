package com.unieventos.proyecto.repository;

import com.unieventos.proyecto.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepo extends MongoRepository<Usuario, String> {


}
