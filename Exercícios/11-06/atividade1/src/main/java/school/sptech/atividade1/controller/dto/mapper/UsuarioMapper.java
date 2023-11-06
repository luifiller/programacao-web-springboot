package school.sptech.atividade1.controller.dto.mapper;

import school.sptech.atividade1.controller.dto.UsuarioCreateRequestDto;
import school.sptech.atividade1.controller.dto.UsuarioResponseDto;
import school.sptech.atividade1.controller.dto.UsuarioSimpleResponse;
import school.sptech.atividade1.entity.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioCreateRequestDto dto) {
        Usuario usuario = new Usuario();

        usuario.setNome(dto.getNome());
        usuario.setSobrenome(dto.getSobrenome());
        usuario.setCpf(dto.getCpf());
        usuario.setEmail(dto.getEmail());
        usuario.setDataNascimento(dto.getDataNascimento());

        return usuario;
    }

    public static UsuarioResponseDto toUsuarioReponseDto(Usuario entity) {
        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();

        usuarioResponseDto.setId(entity.getId());
        usuarioResponseDto.setNomeCompleto(String.format("%s %s", entity.getNome(), entity.getSobrenome()));
        usuarioResponseDto.setDocumento(entity.getCpf());
        usuarioResponseDto.setDataNascimento(entity.getDataNascimento());
        usuarioResponseDto.setContato(entity.getEmail());

        return usuarioResponseDto;
    }

    public static UsuarioSimpleResponse toUsuarioSimpleResponse(Usuario entity) {
        UsuarioSimpleResponse usuarioSimpleResponse = new UsuarioSimpleResponse();

        usuarioSimpleResponse.setId(entity.getId());
        usuarioSimpleResponse.setNomeCompleto(String.format("%s %s", entity.getNome(), entity.getSobrenome()));

        return usuarioSimpleResponse;
    }
}
