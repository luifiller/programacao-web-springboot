package school.sptech.avaliacaocontinuada2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.avaliacaocontinuada2.entity.Producao;
import school.sptech.avaliacaocontinuada2.repository.ProducaoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/producoes")
public class LivroController {

    /*
        Precisamos da sua ajuda aqui!
        Escreva os métodos abaixo:
    */
    private final ProducaoRepository repository;

    public LivroController(ProducaoRepository repository) {
        this.repository = repository;
    }

    //1. Buscar Produções por Nome do Diretor:
    @GetMapping("/diretor")
    public ResponseEntity<List<Producao>> listagemAutor(@RequestParam String nome) {
        List<Producao> listagem = this.repository.findAll();
        List<Producao> listagemPorNome = this.repository.findProducaosByDiretorEquals(nome);

        if (listagem.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(listagemPorNome);
    }

    //2. Buscar Produções por Parte do Título:
    @GetMapping("/titulo")
    public ResponseEntity<List<Producao>> listagemTitulo(@RequestParam String nome) {
        List<Producao> listagem = this.repository.findAll();
        List<Producao> listagemPorTitulo = this.repository.findProducaosByTituloContainsIgnoreCase(nome);

        if (listagem.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(listagemPorTitulo);
    }

    //3. Contar Todas as Produções de um Gênero:
    @GetMapping("/genero")
    public ResponseEntity<Integer> listagemEditora(@RequestParam String nome) {
        Integer quantidade = this.repository.countProducaosByGeneroEquals(nome);

        return ResponseEntity.ok().body(quantidade);
    }

    //4. Buscar Produções com Data de Lançamento Após uma Data Específica:
    @GetMapping("/recentes")
    public ResponseEntity<List<Producao>> listagemRecentes(@RequestParam LocalDate data) {
        List<Producao> listagem = this.repository.findAll();
        List<Producao> listagemPorData = this.repository.findProducaosByDataLancamentoAfter(data);

        if (listagem.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(listagemPorData);
    }

    //5. Buscar Produções com Data de Lançamento Antes ou na Data Específica:
    @GetMapping("/antigos")
    public ResponseEntity<List<Producao>> listagemAntigos(@RequestParam LocalDate data) {
        List<Producao> listagem = this.repository.findAll();
        List<Producao> listagemPorData = this.repository.findProducaosByDataLancamentoLessThanEqual(data);

        if (listagem.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(listagemPorData);
    }

    //6. Buscar a Produção Mais Votada (maior quantidade de avaliações):
    @GetMapping("/notas/mais-votado")
    public ResponseEntity<Producao> buscarMaisVotado() {
        Optional<Producao> listagemPorAvaliacaoOpt = this.repository.findFirstByOrderByQuantidadeAvaliacoesDesc();

        return ResponseEntity.of(listagemPorAvaliacaoOpt);
    }

    //7. Buscar Top 3 Produções com Maior Nota no IMDB:
    @GetMapping("/notas/top3")
    public ResponseEntity<List<Producao>> listagemMaisBaratos() {
        List<Producao> listagem = this.repository.findAll();
        List<Producao> top3 = this.repository.findTop3ByOrderByNotaImdbDesc();

        if (listagem.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(top3);
    }
}
