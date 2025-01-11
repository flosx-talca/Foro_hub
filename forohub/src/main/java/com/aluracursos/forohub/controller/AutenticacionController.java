package com.aluracursos.forohub.controller;


import com.aluracursos.forohub.Infraestructura.security.TokenService;
import com.aluracursos.forohub.domain.usuario.AutenticarUsuarioDTO;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class AutenticacionController {

    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    public AutenticacionController( AuthenticationManager authenticationManager,
                                    TokenService tokenService){
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;

    }

    @PostMapping
    public ResponseEntity auntenticarUsuario(@RequestBody @Valid AutenticarUsuarioDTO autenticarUsuarioDTO){
        Authentication authToken = new UsernamePasswordAuthenticationToken(autenticarUsuarioDTO.email(),
                autenticarUsuarioDTO.clave());
        authenticationManager.authenticate(authToken);
       var JWTtoken = tokenService.generarToken();
        return ResponseEntity.ok(JWTtoken);



    }



}
