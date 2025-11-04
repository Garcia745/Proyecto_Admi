package repository;

import model.Equipo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepo extends MongoRepository<Equipo, String> {

}
