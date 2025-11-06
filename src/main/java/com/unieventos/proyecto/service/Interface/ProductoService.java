package com.unieventos.proyecto.service.Interface;

import com.unieventos.proyecto.model.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> getAllProducts();
    Producto getProductById(String idProducto);
    String deleteProductById(String idProducto);
    Producto updateProduct(String idProducto, Integer stock);
}
