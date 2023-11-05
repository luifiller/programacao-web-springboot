package biblioteca.biblioteca.sptech.school.dto.escritor;

import lombok.Data;

@Data
public class EscritorLivroResponseDTO {
    private Long id;

    private String nome;

    private String nacionalidade;

    private Integer quantidadePublicacoes;

    private Integer idade;
}
