package biblioteca.biblioteca.sptech.school.dto.livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EscLivroResponseDTO {
    @NotBlank
    private String nome;

    @NotBlank
    private String nacionalidade;

    @NotNull
    private Integer quantidadePublicacoes;

    @NotNull
    private Integer idade;
}
