package school.sptech.aula02nivelamento;

public class Heroi {
    private String nome;
    private int poder;
    private String habilidade;
    private int idade;
    private boolean vivo;

    public Heroi(String nome, int poder, String habilidade, int idade, boolean vivo) {
        this.nome = nome;
        this.poder = poder;
        this.habilidade = habilidade;
        this.idade = idade;
        this.vivo = vivo;
    }

    /*
    * Quando utiliza o SpringBoot, sempre precisa utilizar um construtor vazio,
    * pois quando não tiver nenhum valor para os atributos, o SpringBoot
    * tentará instanciar um objeto com os valores nulos e dará problema
    * porque não conseguirá inicializar.
    * */
    public Heroi() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public String getDescricao() {
        return this.poder > 8000 ? "É mais de 8000" : "Fraquinho";
    }

    @Override
    public String toString() {
        return "Heroi{" +
                "nome='" + nome + '\'' +
                ", poder=" + poder +
                ", habilidade='" + habilidade + '\'' +
                ", idade=" + idade +
                ", vivo=" + vivo +
                '}';
    }
}
