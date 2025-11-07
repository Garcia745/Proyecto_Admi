package com.unieventos.proyecto.ProyectoTest;

import com.unieventos.proyecto.model.Usuario;
import com.unieventos.proyecto.model.Rol;
import com.unieventos.proyecto.repository.UsuarioRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class UsuarioTest {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Test
    public void crearUsuario() {
        //Creamos el usuario
        Usuario usuario = Usuario.builder()
                .nombre("Administrador")
                .email("admin@unieventos.com")
                .passwordHash("123456")
                .rol(Rol.Administrador)
                .telefono(List.of("23456","34567"))
                .activo(true)
                .fechaCreacion(LocalDate.now())
                .build();

        usuarioRepo.save(usuario);

    }

    @Test
    public void eliminarUsuario() {
        usuarioRepo.deleteById("690a4f5e74dbcfc8a4fe3dba");
        Usuario usuario = usuarioRepo.findById("690a4f5e74dbcfc8a4fe3dba").orElse(null);
        assertNull(usuario);
    }

}
