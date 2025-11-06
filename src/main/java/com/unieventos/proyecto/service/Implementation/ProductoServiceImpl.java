package com.unieventos.proyecto.service.Implementation;

import com.unieventos.proyecto.model.Producto;
import com.unieventos.proyecto.service.Interface.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {


    @Override
    public List<Producto> getAllProducts() {
        return List.of();
    }
}
