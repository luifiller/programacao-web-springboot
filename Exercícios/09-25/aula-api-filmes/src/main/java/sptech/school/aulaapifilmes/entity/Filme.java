package sptech.school.aulaapifilmes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String diretor;

    @Past
    private LocalDate dataLancamento;

    @NotNull
    @NotBlank
    private Double custoProducao;


    @NotNull
    @NotBlank
    private Boolean indicacaoOscar;

    public Filme() { }

    public Filme(Integer id, String nome, String diretor, LocalDate dataLancamento, Double custoProducao, Boolean indicacaoOscar) {
        this.id = id;
        this.nome = nome;
        this.diretor = diretor;
        this.dataLancamento = dataLancamento;
        this.custoProducao = custoProducao;
        this.indicacaoOscar = indicacaoOscar;
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

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Double getCustoProducao() {
        return custoProducao;
    }

    public void setCustoProducao(Double custoProducao) {
        this.custoProducao = custoProducao;
    }

    public Boolean getIndicacaoOscar() {
        return indicacaoOscar;
    }

    public void setIndicacaoOscar(Boolean indicacaoOscar) {
        this.indicacaoOscar = indicacaoOscar;
    }
}
