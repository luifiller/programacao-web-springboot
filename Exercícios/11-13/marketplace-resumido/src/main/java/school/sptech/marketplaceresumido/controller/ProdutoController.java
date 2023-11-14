package school.sptech.marketplaceresumido.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.marketplaceresumido.controller.dto.mapper.ProdutoMapper;
import school.sptech.marketplaceresumido.entity.Produto;
import school.sptech.marketplaceresumido.service.produto.ProdutoService;
import school.sptech.marketplaceresumido.controller.dto.ProdutoAtualizacaoDto;
import school.sptech.marketplaceresumido.controller.dto.ProdutoConsultaDto;
import school.sptech.marketplaceresumido.controller.dto.ProdutoCriacaoDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoConsultaDto>> listar() {
        List<Produto> lista = produtoService.listar();

        if (lista.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        List<ProdutoConsultaDto> dtos = new ArrayList<>();

        for (Produto produto : lista) {
            ProdutoConsultaDto dto = ProdutoMapper.mapProdutoToProdutoConsultaDto(produto);

            dtos.add(dto);
        }

        return ResponseEntity.status(200).body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoConsultaDto> buscarPorId(@PathVariable Integer id) {
        Produto produto = this.produtoService.buscarPorId(id);

        ProdutoConsultaDto dto = ProdutoMapper.mapProdutoToProdutoConsultaDto(produto);

        return ResponseEntity.status(200).body(dto);
    }

    @PostMapping
    public ResponseEntity<ProdutoConsultaDto> criar(@RequestBody @Valid ProdutoCriacaoDto produtoCriacaoDto) {
        // Transforma Obj de requisição em Entidade
        Produto produto = ProdutoMapper.mapProdutoCriacaoDtoToProduto(produtoCriacaoDto);

        // Solicita ao serviço que cadastre o Obj convertido
        Produto produtoSalvo = this.produtoService.cadastrar(produto);

        // Transforma o Obj cadastradado numa DTO de reposta53
        ProdutoConsultaDto dto = ProdutoMapper.mapProdutoToProdutoConsultaDto(produtoSalvo);

        return ResponseEntity.status(201).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoConsultaDto> atualizar(
            @PathVariable Integer id,
            @RequestBody @Valid ProdutoAtualizacaoDto produtoCriacaoDto) {

        Produto produto = ProdutoMapper.mapProdutoAtualizacaoDtoToProduto(id, produtoCriacaoDto);

        Produto produtoAtualizado = this.produtoService.atualizar(id, produto);

        ProdutoConsultaDto resposta = ProdutoMapper.mapProdutoToProdutoConsultaDto(produtoAtualizado);

        return ResponseEntity.ok(resposta);
    }
}
