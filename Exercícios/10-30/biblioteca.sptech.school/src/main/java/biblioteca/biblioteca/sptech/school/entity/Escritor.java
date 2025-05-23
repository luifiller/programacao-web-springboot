package biblioteca.biblioteca.sptech.school.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Escritor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String nacionalidade;

    private Integer quantidadePublicacoes;

    private Integer idade;

    @OneToMany(mappedBy = "escritor")
    private List<Livro> livros;
}
