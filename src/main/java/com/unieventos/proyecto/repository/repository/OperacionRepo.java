package com.unieventos.proyecto.repository.repository;

import com.unieventos.proyecto.model.Operacion;
import com.unieventos.proyecto.model.OperacionTipo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperacionRepo extends MongoRepository<Operacion, String> {
    List<Operacion> findByTipo(OperacionTipo tipo);
}
