package com.aluracursos.forohub.infraestructura.security;

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

    public String generarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("forohub Allura")
                    .withSubject(usuario.getEmail())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generaFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error al generar el token", exception);
        }
    }

    public String getSubject(String token) {
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("El token no puede ser nulo o vacío");
        }

        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret); // Validando firma
            DecodedJWT verifier = JWT.require(algorithm)
                    .withIssuer("forohub Allura")
                    .build()
                    .verify(token);

            String subject = verifier.getSubject();
            if (subject == null || subject.isEmpty()) {
                throw new IllegalStateException("El token no contiene un subject válido");
            }

            return subject;

        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token no válido: " + exception.getMessage(), exception);
        }
    }

    private Instant generaFechaExpiracion() {
        // Usa ZoneOffset para calcular la expiración
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
