package com.unieventos.proyecto.repository.repository;

import com.unieventos.proyecto.model.Soporte;
import com.unieventos.proyecto.model.SoportePrioridad;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoporteRepo extends MongoRepository<Soporte, String> {
    List<Soporte> findByPrioridad(SoportePrioridad prioridad);
    List<Soporte> findByIdTecnico(String idTecnico);
}
