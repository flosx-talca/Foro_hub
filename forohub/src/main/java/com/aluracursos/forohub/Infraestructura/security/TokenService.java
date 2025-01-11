package com.aluracursos.forohub.Infraestructura.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String generarToken(){
        try {
            Algorithm algorithm = Algorithm.HMAC256("forohub");
            return JWT.create()
                    .withIssuer("forohub Allura")
                    .withSubject("Flosx_Talca")
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }
}
