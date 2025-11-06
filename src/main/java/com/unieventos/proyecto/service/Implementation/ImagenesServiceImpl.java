package com.unieventos.proyecto.service.Implementation;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.unieventos.proyecto.service.Interface.ImagenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
public class ImagenesServiceImpl implements ImagenesService{

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String subirImagen(MultipartFile imagen) throws IOException {
        String nombreUnico = UUID.randomUUID().toString() + "_" + imagen.getOriginalFilename();

        Map uploadResult = cloudinary.uploader().upload(
                imagen.getBytes(),
                ObjectUtils.asMap(
                        "public_id", nombreUnico,
                        "folder", "unieventos" // 👈 opcional: carpeta en Cloudinary
                )
        );

        return uploadResult.get("secure_url").toString(); // retorna URL pública
    }

    @Override
    public void eliminarImagen(String publicId) throws IOException {
        cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
    }
}
