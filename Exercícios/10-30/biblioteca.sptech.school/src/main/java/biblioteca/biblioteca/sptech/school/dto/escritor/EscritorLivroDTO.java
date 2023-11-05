package biblioteca.biblioteca.sptech.school.dto.escritor;

import biblioteca.biblioteca.sptech.school.dto.livro.LivroEscritorDTO;
import lombok.Data;

import java.util.List;

@Data
public class EscritorLivroDTO {
    private String nome;

    private String nacionalidade;

    private Integer quantidadePublicacoes;

    private Integer idade;

    private List<LivroEscritorDTO> livros;
}
