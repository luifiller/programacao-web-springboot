package biblioteca.biblioteca.sptech.school.dto.escritor;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EscritorRequestDTO {
    @NotBlank
    private String nome;

    @NotBlank
    private String nacionalidade;

    @NotNull
    private Integer quantidadePublicacoes;

    @NotNull
    @Min(1)
    @Max(120)
    private Integer idade;
}
