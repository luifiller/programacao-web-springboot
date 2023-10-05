package sptech.school.aulaapifilmes.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import sptech.school.aulaapifilmes.entity.Filme;
import sptech.school.aulaapifilmes.repository.IFilmesRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private IFilmesRepository repository;

    @PostMapping
    public ResponseEntity<Filme> cadastrar(@RequestBody @Valid Filme filme) {
        // return ResponseEntity.status(201).body(this.repository.save(filme));
        return ResponseEntity.created(null).body(this.repository.save(filme));
    }

    @GetMapping
    public ResponseEntity<List<Filme>> listarTodos() {
        List<Filme> filmes = this.repository.findAll();

        if (filmes.isEmpty()) {
            //return ResponseEntity.status(204).build();
            return ResponseEntity.noContent().build();
        }

        // return ResponseEntity.status(200).body(filmes);
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> listar(@PathVariable Integer id) {
        return ResponseEntity.of(this.repository.findById(id));
    }

    @GetMapping("/titulo")
    public ResponseEntity<List<Filme>> buscarTitulo(@RequestParam String nome) {
        List<Filme> listagem = this.repository.findByNomeContainsIgnoreCase(nome);

        if (listagem.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listagem);
    }

    @GetMapping("/data")
    public ResponseEntity<List<Filme>> buscarData(@RequestParam LocalDate data) {
        List<Filme> listagem = this.repository.findByDataLancamentoLessThanEqual(data);

        if (listagem.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listagem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizar(@PathVariable Integer id, @RequestBody @Valid Filme filme) {
        if (this.repository.existsById(id)) {
            filme.setId(id);
            this.repository.save(filme);
            return ResponseEntity.ok(filme);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.notFound().build();
    }
}
