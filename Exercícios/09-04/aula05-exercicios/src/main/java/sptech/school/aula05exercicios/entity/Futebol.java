package sptech.school.aula05exercicios.entity;

public class Futebol {
    private String nome;
    private String treinador;
    private Integer vitorias;
    private Integer derrotas;
    private Integer empates;

    public Futebol(String nome, String treinador, Integer vitorias, Integer derrotas, Integer empates) {
        this.nome = nome;
        this.treinador = treinador;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
    }

    public Futebol() { }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTreinador() {
        return treinador;
    }

    public void setTreinador(String treinador) {
        this.treinador = treinador;
    }

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
    }

    public Integer getEmpates() {
        return empates;
    }

    public void setEmpates(Integer empates) {
        this.empates = empates;
    }

    public Integer getPontuacaoTotal() {
        int totalPontuacaoVitoria = getVitorias() * 3;

        return totalPontuacaoVitoria + getEmpates();
    }

    public Double getAproveitamento() {
        Double totalPontuacaoPossivel = (getVitorias() + getEmpates() + getDerrotas()) * 3.0;

        return (getPontuacaoTotal() / totalPontuacaoPossivel) * 100;
    }
}
