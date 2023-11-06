package biblioteca.biblioteca.sptech.school.dto.livro;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroEscResponseDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String anoPublicacao;

    @NotBlank
    private String autor;

    @NotBlank
    private String editora;

    @NotBlank
    private String genero;

    @NotNull
    @Min(1)
    private Integer quantidadePaginas;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @DecimalMax(value = "9999.0", inclusive = false)
    private Double preco;


    private EscLivroResponseDTO escLivroResponseDTO;
}
