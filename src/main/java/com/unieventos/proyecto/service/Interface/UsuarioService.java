package com.unieventos.proyecto.service.Interface;

import com.unieventos.proyecto.DTOS.LoginDTO;
import com.unieventos.proyecto.DTOS.TokenDTO;
import com.unieventos.proyecto.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

public interface UsuarioService {

    TokenDTO login(LoginDTO loginDTO) throws Exception;

    Usuario obtenerPorEmail(String email) throws Exception;

    // otros métodos: crearUsuario, actualizar, etc.
}
