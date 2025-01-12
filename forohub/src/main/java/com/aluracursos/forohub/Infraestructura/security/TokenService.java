package com.aluracursos.forohub.Infraestructura.security;

import com.aluracursos.forohub.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("forohub Allura")
                    .withSubject(usuario.getEmail())
                    .withClaim("id",usuario.getId())
                    .withExpiresAt(generaFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    public String getSubject(String token){
        System.out.println("toekn en getsubjetrct: "+ token);
        if(token == null){
            throw new RuntimeException();
        }
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret); //validando firma|
            verifier = JWT.require(algorithm)
                    // specify any specific claim validations
                    .withIssuer("forohub Allura")
                    .build()
                    .verify(token);
            verifier.getSubject();
            System.out.println(verifier);
            // decodedJWT = verifier.verify(token);
        } catch (JWTVerificationException exception){
            // Invalid signature/claims
        }
        // assert verifier != null;
        if (verifier.getSubject() == null){
            throw new RuntimeException("verifier invalido");
        }

        return verifier.getSubject();


    }

    private Instant generaFechaExpiracion(){
        //System.out.println(LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00")));
        ZonedDateTime zonedDateTime = LocalDateTime.now().plusHours(2).atZone(ZoneOffset.of("-03:00"));
       // System.out.println(zonedDateTime);
        return zonedDateTime.toInstant();
    }
}
