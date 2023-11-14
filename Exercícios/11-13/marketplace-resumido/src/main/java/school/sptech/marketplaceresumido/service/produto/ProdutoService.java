package school.sptech.marketplaceresumido.service.produto;
import org.springframework.stereotype.Service;
import school.sptech.marketplaceresumido.entity.Produto;
import school.sptech.marketplaceresumido.entity.data.ProdutoRepository;
import school.sptech.marketplaceresumido.entity.exception.EntidadeNaoEncontradaException;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Integer id) {
        return produtoRepository.findById(id)
                .orElseThrow(
                        () -> new EntidadeNaoEncontradaException("Produto não encontrado")
                );
    }

    public Produto cadastrar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizar(Integer id, Produto produto) {
        if (this.produtoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Produto não encontrado");
        }

        produto.setId(id);

        return this.produtoRepository.save(produto);
    }

    public void deletarPorId(Integer id) {
        if (!this.produtoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Produto não encontrado");
        }
        this.produtoRepository.deleteById(id);
    }


}
