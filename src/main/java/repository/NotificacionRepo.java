package repository;

import model.Notificacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepo extends MongoRepository<Notificacion, String> {
    List<Notificacion> findByIdUsuario(String idUsuario);
}
