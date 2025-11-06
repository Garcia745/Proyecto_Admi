package com.unieventos.proyecto.service.Implementation;

import com.unieventos.proyecto.model.Producto;
import com.unieventos.proyecto.repository.repository.ProductoRepo;
import com.unieventos.proyecto.service.Interface.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepo repository;

    @Override
    public List<Producto> getAllProducts() {
        return repository.findAll();
    }
}
