package com.unieventos.proyecto.service.Interface;

import org.springframework.web.multipart.MultipartFile;

public interface ImagenesService {
    /**
     * Sube una imagen a Cloudinary y devuelve su URL pública.
     */
    String subirImagen(MultipartFile imagen) throws Exception;
    /**
     * Elimina una imagen de Cloudinary según su public_id.
     */
    void eliminarImagen(String publicId) throws Exception;
}
