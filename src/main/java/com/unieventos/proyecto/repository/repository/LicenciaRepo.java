package com.unieventos.proyecto.repository.repository;

import com.unieventos.proyecto.model.Licencia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LicenciaRepo extends MongoRepository<Licencia, String> {
    List<Licencia> findByFechaVencimientoBefore(LocalDate fechaLimite);
}
