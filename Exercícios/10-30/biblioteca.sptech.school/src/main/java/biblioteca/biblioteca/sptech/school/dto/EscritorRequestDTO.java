package biblioteca.biblioteca.sptech.school.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

@Data
public class EscritorRequestDTO {
    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    private String nacionalidade;

    @NotNull
    private Integer quantidadePublicacoes;

    @NotNull
    @Min(1)
    private Integer idade;
}
