package com.unieventos.proyecto.repository.repository;

import com.unieventos.proyecto.model.Compra;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepo extends MongoRepository<Compra, String> {
}
