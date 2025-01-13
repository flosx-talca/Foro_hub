package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.infraestructura.security.DevolverJWTToken;
import com.aluracursos.forohub.infraestructura.security.TokenService;
import com.aluracursos.forohub.domain.usuario.AutenticarUsuarioDTO;
import com.aluracursos.forohub.domain.usuario.Usuario;
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
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var jwtToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DevolverJWTToken(jwtToken));
    }



}
