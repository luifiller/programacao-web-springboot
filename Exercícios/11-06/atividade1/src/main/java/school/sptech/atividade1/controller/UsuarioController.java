package school.sptech.atividade1.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.atividade1.controller.dto.UsuarioCreateRequestDto;
import school.sptech.atividade1.controller.dto.UsuarioResponseDto;
import school.sptech.atividade1.controller.dto.UsuarioSimpleResponse;
import school.sptech.atividade1.controller.dto.mapper.UsuarioMapper;
import school.sptech.atividade1.entity.Usuario;
import school.sptech.atividade1.service.UsuarioService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listar() {
        List<Usuario> usuarios = usuarioService.listar();

        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<UsuarioResponseDto> usariosDto = usuarios
                .stream()
                .map(UsuarioMapper::toUsuarioReponseDto).toList();

        return ResponseEntity.ok(usariosDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> buscarPorId(@PathVariable int id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        UsuarioResponseDto usuarioResponseDto = UsuarioMapper.toUsuarioReponseDto(usuario);

        return ResponseEntity.ok(usuarioResponseDto);
    }

    @GetMapping("/resumo")
    public ResponseEntity<List<UsuarioSimpleResponse>> listarResumo() {
        List<Usuario> usuarios = usuarioService.listar();
        List<UsuarioSimpleResponse> usuarioSimpleResponses = usuarios
                .stream()
                .map(UsuarioMapper::toUsuarioSimpleResponse).toList();

        return ResponseEntity.status(200).body(usuarioSimpleResponses);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> salvar(@RequestBody @Valid UsuarioCreateRequestDto usuarioDto) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioDto);
        usuarioService.salvar(usuario);

        UsuarioResponseDto usuarioResponseDto = UsuarioMapper.toUsuarioReponseDto(usuario);
        return ResponseEntity.status(201).body(usuarioResponseDto);
    }
}
