package biblioteca.biblioteca.sptech.school.dto;

import lombok.Data;

import java.util.List;

@Data
public class EscritorLivroDTO {
    private Long id;

    private String nome;

    private String nacionalidade;

    private Integer quantidadePublicacoes;

    private Integer idade;

    private List<LivroEscritorDTO> livros;
}
