package school.sptech.marketplaceresumido.service.produto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import school.sptech.marketplaceresumido.entity.Produto;
import school.sptech.marketplaceresumido.entity.data.ProdutoRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {
    @InjectMocks
    private ProdutoService produtoService;

    @Mock
    private ProdutoRepository produtoRepository;

    @Test
    @DisplayName("Retornar lista com 3 produtos")
    void deveRetornarListaDeProdutos() {
        ProdutoService service = new ProdutoService(produtoRepository);

        // given
        List<Produto> produtos = List.of(
                new Produto(),
                new Produto(),
                new Produto()
        );

        // when
        Mockito.when(produtoRepository.findAll()).thenReturn(produtos);

        // then
        List<Produto> produtosRetorno = produtoService.listar();

        // assert
        assertFalse(produtosRetorno.isEmpty());
        assertEquals(3, produtosRetorno.size());
    }

    @Test
    @DisplayName("Retornar lista vazia")
    void listaVazia() {
        List<Produto> produtos = Collections.emptyList();

        Mockito.when(produtoRepository.findAll()).thenReturn(produtos);

        List<Produto> produtosRetorno = produtoService.listar();
        assertTrue(produtosRetorno.isEmpty());
    }

    @Test
    @DisplayName("Retornar produto por id")
    void retornaProdutoPorId() {
        Produto produto = new Produto(
                1, "Abobora", "Laranja", "123456789", 10.0
        );
        Integer id = 1;
        s

        Mockito.when(produtoRepository.findById(1)).thenReturn(Optional.of(produto));

        Produto produtoRetorno = produtoService.buscarPorId(1);

        assertEquals(produto.getId(), produtoRetorno.getId());
        assertEquals("Produto 1", produtoRetorno.getNome());
        assertEquals("Descrição do produto 1", produtoRetorno.getDescricao());
        assertEquals("123456789", produtoRetorno.getCodigoBarra());
        assertEquals(10.0, produtoRetorno.getPreco());

        Mockito.verify(produtoRepository, Mockito.times(1)).findById(1);
    }
}

