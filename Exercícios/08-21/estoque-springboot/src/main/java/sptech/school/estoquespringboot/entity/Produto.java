package sptech.school.estoquespringboot.entity;

public class Produto {
    private String nome;
    private Double preco;
    private Integer qtdEstoque;
    private Double valorTotalEstoque;

    public Produto(String nome, Double preco, Integer qtdEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    public Produto() { }

    public Double getValorTotalEstoque() {
        return valorTotalEstoque;
    }

    public void setValorTotalEstoque() {
        this.valorTotalEstoque = getPreco() * getQtdEstoque();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    @Override
    public String toString() {
        return "Produto {" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", qtdEstoque=" + qtdEstoque +
                '}';
    }
}
