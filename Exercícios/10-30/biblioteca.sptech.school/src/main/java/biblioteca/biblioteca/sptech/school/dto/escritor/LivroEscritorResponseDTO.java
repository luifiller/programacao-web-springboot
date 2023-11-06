package biblioteca.biblioteca.sptech.school.dto.escritor;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class LivroEscritorResponseDTO {
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
}
