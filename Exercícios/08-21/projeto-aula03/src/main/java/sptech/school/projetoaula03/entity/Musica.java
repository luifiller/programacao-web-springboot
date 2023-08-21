package sptech.school.projetoaula03.entity;

import java.time.LocalDate;
import java.util.Locale;

/**
 * Entity ou Model ou Domain são classes que
 * representam uma tabela do banco de dados
 */

public class Musica {
    private String nome;
    private String artista;

    /*
    * LocalDate -> YYYY-MM-DD
    * LocalDateTime -> YYYY-MM-DD HH:MM:SS
    * Há diversos tipos de
    * */
    private LocalDate dataCriacao = LocalDate.now();

    public String getNome() {
        return nome;
    }

    public Musica(String nome, String artista) {
        this.nome = nome;
        this.artista = artista;
    }

    public Musica() {}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
