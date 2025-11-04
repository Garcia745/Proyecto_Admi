package repository;

import model.Solicitud;
import model.SolicitudEstado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudRepo extends MongoRepository<Solicitud, String> {
    List<Solicitud> findByIdUsuario(String idUsuario);
    List<Solicitud> findByEstado(SolicitudEstado estado);
}
