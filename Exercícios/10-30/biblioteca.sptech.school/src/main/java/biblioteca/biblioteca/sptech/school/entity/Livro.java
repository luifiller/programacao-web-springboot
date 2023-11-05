package biblioteca.biblioteca.sptech.school.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate anoPublicacao;

    private String autor;

    private String editora;

    private String genero;

    private Integer quantidadePaginas;

    private Double preco;

    @ManyToOne
    private Escritor escritor;
}
