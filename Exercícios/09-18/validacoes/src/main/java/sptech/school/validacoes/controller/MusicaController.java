package sptech.school.validacoes.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.validacoes.entity.Musica;
import sptech.school.validacoes.repository.IMusicaRepository;

import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private IMusicaRepository repository;

    @GetMapping
    public ResponseEntity<List<Musica>> listar() {
        List<Musica> musicas = this.repository.findAll();

        if (musicas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(musicas);
    }

    @PostMapping
    public ResponseEntity<Musica> cadastrar(@RequestBody @Valid Musica novaMusica) {
        Musica musicaSalva = this.repository.save(novaMusica);
        return ResponseEntity.status(201).body(musicaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Musica> atualizar(@PathVariable int id, @RequestBody Musica musicaAtualizada) {
        musicaAtualizada.setId(id);
        if (this.repository.existsById(id)) {
            this.repository.save(musicaAtualizada);
        }

        return ResponseEntity.status(200).body(musicaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Musica> deletar(@PathVariable int id) {
        if (!this.repository.existsById(id)) {
            return ResponseEntity.status(404).build();
        }

        this.repository.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
