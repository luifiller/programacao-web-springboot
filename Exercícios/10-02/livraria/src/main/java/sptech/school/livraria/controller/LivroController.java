package sptech.school.livraria.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.livraria.entity.Livro;
import sptech.school.livraria.repository.LivroRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro) {
        Livro livroSalvo = this.repository.save(livro);
        return ResponseEntity.created(null).body(livroSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listar() {
        List<Livro> livros = this.repository.findAll();

        if (livros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Integer id) {
        Optional<Livro> livroOpt = this.repository.findLivroById(id);

        if (livroOpt.isPresent()) {
            return ResponseEntity.ok(livroOpt.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/titulo/autor/{id}")
    public ResponseEntity<Livro> atualizarTituloAutor(@PathVariable Integer id, @RequestParam String titulo, @RequestParam String autor) {
        Optional<Livro> livroOpt = this.repository.findById(id);

        if (livroOpt.isPresent()) {
            this.repository.atualizarTituloAutor(titulo, autor, id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Livro> deletarLivroPorId(@PathVariable Integer id) {
        Optional<Livro> livroOpt = this.repository.findById(id);

        if (livroOpt.isPresent()) {
            this.repository.deletarLivroPorId(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/naopublicados")
    public ResponseEntity<List<Livro>> buscarLivrosNaoPublicados(@RequestParam LocalDate data) {
        List<Livro> livros = this.repository.buscarLivrosNaoPublicados(data);

        if (livros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(livros);
    }

    @GetMapping("/estoque")
    public ResponseEntity<List<Livro>> buscarLivrosDisponiveis() {
        List<Livro> livros = this.repository.findLivrosByDisponibilidadeEstoqueTrue();

        if (livros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(livros);
    }

    @GetMapping("/top5")
    public ResponseEntity<List<Livro>> buscarTop5Livros(@RequestParam LocalDate data) {
        List<Livro> livros = this.repository.findTop5ByDataLancamentoLessThanEqualOrderByDataLancamentoDesc(data);

        if (livros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(livros);
    }

    @GetMapping("/mais-caro")
    public ResponseEntity<Livro> buscarLivroMaisCaro() {
        Livro livro = this.repository.findFirstByOrderByPrecoDesc();

        if (livro == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(livro);
    }
}
