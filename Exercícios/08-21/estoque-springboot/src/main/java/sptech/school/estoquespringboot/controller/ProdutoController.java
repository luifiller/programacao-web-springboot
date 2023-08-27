package sptech.school.estoquespringboot.controller;

import org.springframework.web.bind.annotation.*;
import sptech.school.estoquespringboot.entity.Produto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();

    @PostMapping
    public Produto cadastrar(@RequestBody Produto novoProduto) {
        for (Produto produto : this.produtos) {
            if (novoProduto.getNome().equals(produto.getNome())) {
                produto.setQtdEstoque(produto.getQtdEstoque() + novoProduto.getQtdEstoque());
                produto.setValorTotalEstoque();

                System.out.println("Produto já registrado. \n " +
                        "Quantidade e valor total estoque atualizados com sucesso!");

                return produto;
            }
        }

        this.produtos.add(novoProduto);
        novoProduto.setValorTotalEstoque();

        return novoProduto;
    }

    @GetMapping
    public List<Produto> listar() {
        return this.produtos;
    }

    @GetMapping("estoque/{qtdEstoque}")
    public List<Produto> listarQtdEstoqueMaior10(@PathVariable int qtdEstoque) {
        List<Produto> produtosMaior10 = new ArrayList<>();

        for (Produto produto: this.produtos) {
            if (produto.getQtdEstoque() > 10) {
                produtosMaior10.add(produto);
            }
        }

        return produtosMaior10;
    }

    @PutMapping("/{indice}")
    public Produto atualizar(@PathVariable int indice, @RequestBody Produto produtoAtualizado) {
        if (indice >= 0 && indice < this.produtos.size()) {
            this.produtos.set(indice, produtoAtualizado);

            produtoAtualizado.setValorTotalEstoque();

            return produtoAtualizado;
        }

        return null;
    }
}
