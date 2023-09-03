package sptech.school.aula04verbsstatus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.aula04verbsstatus.entity.Filme;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    List<Filme> filmes = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Filme>> listar() {
        if (filmes.isEmpty()) {
            // build() é umm corpo null como se fosse um .body(null)
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(filmes);
    }

    @PostMapping
    public ResponseEntity<Filme> cadastrar(@RequestBody Filme novoFilme) {
        if (novoFilme.getNome() == null || novoFilme.getDiretor() == null || novoFilme.getAnoLancamento() == 0 || novoFilme.getCustoProducao() == null) {
            return ResponseEntity.status(400).build();
        }

        filmes.add(novoFilme);
        return ResponseEntity.status(201).body(novoFilme);
    }

    // PUT - Devolve o objeto atualizado
    @PutMapping("/{indice}")
    public ResponseEntity<Filme> atualizar(@RequestBody Filme filme, @PathVariable int indice) {
        boolean indiceValido = indice < 0 || indice >= filmes.size();

        if (!indiceValido) {
            return ResponseEntity.status(404).build();
        }
            filmes.set(indice, filme);
            return ResponseEntity.status(200).body(filme);
    }

    // DELETE - 200 ou 204(Preferível)
    @DeleteMapping("/{indice}")
    public ResponseEntity<Void> deletar(@PathVariable int indice) {
        boolean indiceValido = indice >= 0 && indice < filmes.size();

        if (!indiceValido) {
            return ResponseEntity.status(404).build();
        }
            filmes.remove(indice);
            return ResponseEntity.status(204).build();
    }

    // GET POR ID - Devolve por índice
    @GetMapping("/{indice}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable int indice) {
        boolean indiceValido = indice >= 0 && indice < filmes.size();

        if (!indiceValido) {
            return ResponseEntity.status(404).build();
        }
            return ResponseEntity.status(200).body(filmes.get(indice));
    }
}
