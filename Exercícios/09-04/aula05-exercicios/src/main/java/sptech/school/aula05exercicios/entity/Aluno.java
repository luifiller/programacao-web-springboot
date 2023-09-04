package sptech.school.aula05exercicios.entity;

public class Aluno {
    private String nome;
    private String email;
    private Double notaContinuada1;
    private Double notaContinuada2;
    private Double notaContinuada3;
    private Double notaIntegrada;

    public Aluno(String nome, String email, Double notaContinuada1, Double notaContinuada2, Double notaContinuada3, Double notaIntegrada) {
        this.nome = nome;
        this.email = email;
        this.notaContinuada1 = notaContinuada1;
        this.notaContinuada2 = notaContinuada2;
        this.notaContinuada3 = notaContinuada3;
        this.notaIntegrada = notaIntegrada;
    }

    public Aluno() { }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getNotaContinuada1() {
        return notaContinuada1;
    }

    public void setNotaContinuada1(Double notaContinuada1) {
        this.notaContinuada1 = notaContinuada1;
    }

    public Double getNotaContinuada2() {
        return notaContinuada2;
    }

    public void setNotaContinuada2(Double notaContinuada2) {
        this.notaContinuada2 = notaContinuada2;
    }

    public Double getNotaContinuada3() {
        return notaContinuada3;
    }

    public void setNotaContinuada3(Double notaContinuada3) {
        this.notaContinuada3 = notaContinuada3;
    }

    public Double getNotaIntegrada() {
        return notaIntegrada;
    }

    public void setNotaIntegrada(Double notaIntegrada) {
        this.notaIntegrada = notaIntegrada;
    }

    public Double getNotaFinal() {
        // nota final é a média das continuadas mais a nota da integrada. A média das continuadas vale 40% e a nota da integrada vale 60%.
        return (((notaContinuada1 + notaContinuada2 + notaContinuada3) / 3) * 0.4) + (notaIntegrada * 0.6);
    }
}
