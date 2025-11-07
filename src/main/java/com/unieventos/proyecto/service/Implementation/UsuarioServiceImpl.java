package com.unieventos.proyecto.service.Implementation;

import com.unieventos.proyecto.DTOS.LoginDTO;
import com.unieventos.proyecto.DTOS.TokenDTO;
import com.unieventos.proyecto.config.JWTUtils;
import com.unieventos.proyecto.model.Usuario;
import com.unieventos.proyecto.repository.UsuarioRepo;
import com.unieventos.proyecto.service.Interface.UsuarioService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private UsuarioRepo usuarioRepo;
    private JWTUtils jwtUtils;

//Realiza una encriptación o hashing de la contraseña original del usuario.
    public String encriptarPassword(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode( password );
    }

    @Override
    public Usuario obtenerPorEmail(String email) throws Exception {
        return usuarioRepo.findByEmail(email).orElseThrow();
    }

    private Map<String, Object> construirClaims(Usuario usuario) {
        return Map.of(
                "rol", usuario.getRol(),
                "nombre", usuario.getNombre(),
                "id", usuario.getId()
        );
    }

    @Override
    public TokenDTO login(LoginDTO loginDTO) throws Exception {
        Usuario usuario = obtenerPorEmail(loginDTO.getEmail());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if(!passwordEncoder.matches(loginDTO.getPassword(),usuario.getPassword())){
            throw new Exception("La contraseña es incorrecta");
        }
        Map<String, Object> map = construirClaims(usuario);
        return new TokenDTO(jwtUtils.generarToken(usuario.getEmail(),map));
    }
}
