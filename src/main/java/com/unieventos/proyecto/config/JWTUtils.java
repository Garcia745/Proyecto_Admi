package com.unieventos.proyecto.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

@Component
public class JWTUtils {


    public String generarToken(String email, Map<String, Object> claims){

        //Fecha y hora de creacion
        Instant now = Instant.now();

        return Jwts.builder()
                .claims(claims) // agrega el mapa al token
                .subject(email) // define el “sub” del token
                .issuedAt(Date.from(now)) // fecha de creación
                .expiration(Date.from(now.plus(1L, ChronoUnit.HOURS))) // fecha de expiración
                .signWith( getKey() ) // firma con clave secreta
                .compact(); // convierte todo en string final
    }
    //Valida y decodifica el token
    public Jws<Claims> parseJwt(String jwtString) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, IllegalArgumentException {
        JwtParser jwtParser = Jwts.parser().verifyWith( getKey() ).build();
        return jwtParser.parseSignedClaims(jwtString);
    }

    private SecretKey getKey(){
        String claveSecreta = "secretsecretsecretsecretsecretsecretsecretsecret";
        byte[] secretKeyBytes = claveSecreta.getBytes();
        return Keys.hmacShaKeyFor(secretKeyBytes);
    }
}
