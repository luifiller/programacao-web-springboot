package school.sptech.atividade1.controller.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
public class UsuarioResponseDto {

    private Integer id;

    private String nomeCompleto;

    private String documento;

    private LocalDate dataNascimento;

    private String contato;

    public int getIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

}
