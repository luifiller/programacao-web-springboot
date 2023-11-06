package biblioteca.biblioteca.sptech.school.dto.escritor;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class EscritorLivroResponseDTO {
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

    private List<LivroEscritorResponseDTO> livros;
}
