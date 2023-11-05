package biblioteca.biblioteca.sptech.school.dto.livro;

import lombok.Data;

@Data
public class LivroEscritorDTO {
    private String nome;

    private String anoPublicacao;

    private String autor;

    private String editora;

    private String genero;

    private Integer quantidadePaginas;

    private Double preco;
}
