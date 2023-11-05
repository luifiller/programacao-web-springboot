package biblioteca.biblioteca.sptech.school.dto;

import lombok.Data;

@Data
public class LivroEscritorDTO {
    private Long id;

    private String nome;

    private String anoPublicacao;

    private String autor;

    private String editora;

    private String genero;

    private Integer quantidadePaginas;

    private Double preco;
}
