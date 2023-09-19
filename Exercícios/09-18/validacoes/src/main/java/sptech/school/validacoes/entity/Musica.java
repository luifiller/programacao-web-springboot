package sptech.school.validacoes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity // identificar que é uma entidade do banco de dados, espelhando a tabela e utilizando ORM
public class Musica {

    @Id // indica a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremento
    private Integer id;
    @NotBlank
    private String nome;
    @NotBlank
    @Size(min = 3, max = 30, message = "Mínimo de 3 caracteres e máximo de 30 ")
    private String album;
    private LocalDate dataLancamento;
    private Double nota;
    @Min(1)
    private Integer ranking;
/*  Aplicações de outros Validations
    @Email
    private String email;

    @CPF
    private String cpfResponsavel;

    @CNPJ
    private String cnpjResponsavel;*/

    public Musica() {
    }

    public Musica(Integer id, String nome, String album, LocalDate dataLancamento, Double nota, Integer ranking) {
        this.id = id;
        this.nome = nome;
        this.album = album;
        this.dataLancamento = dataLancamento;
        this.nota = nota;
        this.ranking = ranking;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @PastOrPresent
    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }


}
