package repository;

import model.Soporte;
import model.SoportePrioridad;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoporteRepo extends MongoRepository<Soporte, String> {
    List<Soporte> findByPrioridad(SoportePrioridad prioridad);
    List<Soporte> findByIdTecnico(String idTecnico);
}
