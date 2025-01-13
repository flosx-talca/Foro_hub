package com.aluracursos.forohub.domain.topico;

import com.aluracursos.forohub.infraestructura.errores.ValidacionException;
import com.aluracursos.forohub.domain.topico.validaciones.ValidadorTopico;
import com.aluracursos.forohub.domain.usuario.Usuario;
import com.aluracursos.forohub.domain.usuario.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final UriComponentsBuilder uriComponentsBuilder;
    private final List<ValidadorTopico> validadores;

     public TopicoService(TopicoRepository topicoRepository,
                          UsuarioRepository usuarioRepository,
                          UriComponentsBuilder uriComponentsBuilder,
                          List<ValidadorTopico> validadores) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.uriComponentsBuilder = uriComponentsBuilder;
        this.validadores = validadores;
    }

    public ResponseEntity<DevolverTopicoDTO> registraTopico(RegistrarTopicoDTO datos) {
        var fecha = generaFechaActual();
        validadores.forEach(v -> v.validar(datos.titulo(), datos.mensaje(), datos.idUsuario()));
        Usuario  usuario = usuarioRepository.findById(datos.idUsuario())
                .orElseThrow(() -> new ValidacionException("Usuario no encontrado"));
        Topico topico = generaObjTopico(datos,  usuario, fecha);
        DevolverTopicoDTO topicoSalida = generaDevolverTopico(topico);
        URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(Collections.singletonMap("id", topico.getId())).toUri();
        return ResponseEntity.created(url).body(topicoSalida);

    }

    public LocalDateTime generaFechaActual(){
        return  LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    public Topico  generaObjTopico(RegistrarTopicoDTO datos , Usuario usuario, LocalDateTime fecha ){
         Topico topico = new Topico(datos, usuario, fecha);
         return topicoRepository.save(topico);

    }

    public DevolverTopicoDTO generaDevolverTopico(Topico topico){
        return new DevolverTopicoDTO(topico.getId(), topico.getTitulo(),
                topico.getMensaje(), topico.getNombreCurso(),topico.getFechaCreacion(),topico.getUsuario().getId());

    }

    public ResponseEntity<DevolverTopicoDTO> topicoPorId(Long id){
        Topico topico = buscarTopico(id);
        var topicoDTO = generaDevolverTopico(topico);
        return ResponseEntity.ok(topicoDTO);

    }

    public ResponseEntity<Page<DevolverListadoTopicoDTO>> retornaListadoTopico(Pageable pagina) {
          return ResponseEntity.ok( topicoRepository.findAll(pagina)
                .map(topico -> new DevolverListadoTopicoDTO(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getNombreCurso(),
                topico.getFechaCreacion(),
                topico.getUsuario() != null ? topico.getUsuario().getEmail() : null
        )));

    }

    public ResponseEntity <DevolverTopicoDTO> actualizarTopico(ActualizarTopicoDTO datos, Long id){
        Topico topico = buscarTopico(id);
        validadores.forEach(v -> v.validar(datos.titulo(), datos.mensaje(), topico.getUsuario().getId()));
         topico.actualizarDatos(datos, id);
         return ResponseEntity.ok( new DevolverTopicoDTO(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getNombreCurso(), topico.getFechaCreacion(),topico.getUsuario().getId()));

    }

    public ResponseEntity eliminarTopico(Long id){
         Topico topico = buscarTopico(id);
         validadores.forEach(v -> v.validar(null, null, topico.getUsuario().getId()));
         topicoRepository.deleteById(id);
         return ResponseEntity.noContent().build();

    }

    public Topico buscarTopico(Long id){
        return topicoRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(" Topico no encontrado en la base de datos"));
    }

}


