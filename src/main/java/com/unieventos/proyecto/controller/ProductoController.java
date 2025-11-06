package com.unieventos.proyecto.controller;

import com.unieventos.proyecto.controller.dto.UpdateProduct;
import com.unieventos.proyecto.model.Producto;
import com.unieventos.proyecto.service.Interface.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/producto/")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        return ResponseEntity.ok().body(productoService.getAllProducts());
    }
    @GetMapping("{id}")
    public ResponseEntity<Producto> findById(@PathVariable("id") String idProducto) {
        return ResponseEntity.ok(productoService.getProductById(idProducto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") String idProducto) {
        return ResponseEntity.ok(productoService.deleteProductById(idProducto));
    }

    @PutMapping
    public ResponseEntity<Producto> updateProducto(@RequestBody UpdateProduct updateProduct) {
        return ResponseEntity.ok(productoService.updateProduct(updateProduct.idProduct(), updateProduct.stock()));
    }

}
