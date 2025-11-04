package repository;

import  model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface UsuarioRepo extends MongoRepository<Usuario, String> {

}
