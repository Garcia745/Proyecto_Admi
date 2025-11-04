package com.unieventos.proyecto.repository;

import com.unieventos.proyecto.model.DetalleSolicitud;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleSolicitudRepo extends MongoRepository<DetalleSolicitud, String> {
    List<DetalleSolicitud> findByIdSolicitud(String idSolicitud);
}
