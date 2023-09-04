package sptech.school.aula05exercicios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.aula05exercicios.entity.Aluno;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    List<Aluno> alunos = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno novoAluno) {
        boolean isNomeValid = novoAluno.getNome().trim().length() >= 3
                && novoAluno.getNome() != null
                && !novoAluno.getNome().isBlank();
        boolean isEmailValid = novoAluno.getEmail().contains("@")
                && novoAluno.getEmail().contains(".school")
                && novoAluno.getEmail() != null
                && !novoAluno.getEmail().isBlank();
        boolean isNotasValid = novoAluno.getNotaContinuada1() >= 0.0 && novoAluno.getNotaContinuada1() <= 10.0
                && novoAluno.getNotaContinuada2() >= 0.0 && novoAluno.getNotaContinuada2() <= 10.0
                && novoAluno.getNotaContinuada3() >= 0.0 && novoAluno.getNotaContinuada3() <= 10.0
                && novoAluno.getNotaIntegrada() >= 0.0 && novoAluno.getNotaIntegrada() <= 10.0;

        if (!isNomeValid || !isEmailValid || !isNotasValid) {
            return ResponseEntity.status(400).build();
        }

        alunos.add(novoAluno);
        return ResponseEntity.status(201).body(novoAluno);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listarTodosAlunos() {
        if (alunos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(alunos);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Aluno> listarAluno(@PathVariable int indice) {
        boolean isIndiceValid = indice >= 0 && indice < alunos.size();

        if (alunos.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else if (!isIndiceValid) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(alunos.get(indice));
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable int indice, @RequestBody Aluno alunoAtualizado) {
        boolean isIndiceValid = indice >= 0 && indice < alunos.size();

        if (alunos.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else if (!isIndiceValid) {
            return ResponseEntity.status(404).build();
        }

        alunos.set(indice, alunoAtualizado);
        return ResponseEntity.status(200).body(alunoAtualizado);
    }
}
