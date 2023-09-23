package sptech.school.filmesexercicio.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.filmesexercicio.entity.Filme;
import sptech.school.filmesexercicio.repository.IFilmesRepository;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private IFilmesRepository repository;

    @GetMapping
    public ResponseEntity<List<Filme>> listarTodos() {
        List<Filme> filmes = this.repository.findAll();

        if (filmes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(filmes);
    }

    @PostMapping
    public ResponseEntity<Filme> cadastrar(@RequestBody @Valid Filme filme) {
        return ResponseEntity.status(201).body(this.repository.save(filme));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizar(@PathVariable int id, @RequestBody @Valid Filme filme) {
        filme.setId(id);

        if (!this.repository.existsById(id)) {
            return ResponseEntity.status(404).build();
        }

        this.repository.save(filme);
        return ResponseEntity.status(200).body(filme);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Filme> deletar(@PathVariable int id) {
        if (!this.repository.existsById(id)) {
            return ResponseEntity.status(404).build();
        }

        this.repository.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
