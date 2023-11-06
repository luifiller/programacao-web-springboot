package biblioteca.biblioteca.sptech.school.controller;

import biblioteca.biblioteca.sptech.school.dto.escritor.LivroEscritorResponseDTO;
import biblioteca.biblioteca.sptech.school.dto.livro.LivroEscResponseDTO;
import biblioteca.biblioteca.sptech.school.entity.Livro;
import biblioteca.biblioteca.sptech.school.mapper.LivroMapper;
import biblioteca.biblioteca.sptech.school.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {
    private final LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroEscResponseDTO>> findAll() {
        List<Livro> livros = livroService.listarTodos();

        List<LivroEscResponseDTO> livrosDto = livros.stream()
                .map(LivroMapper::toLivroEscritorDTO)
                .toList();

        return ResponseEntity.ok(livrosDto);
    }

    @GetMapping("/nome")
    public ResponseEntity<List<LivroEscResponseDTO>> listarPorNome(@RequestParam String nome) {
        List<Livro> livros = livroService.listarPorNome(nome);

        List<LivroEscResponseDTO> livrosDto = livros.stream()
                .map(LivroMapper::toLivroEscritorDTO)
                .toList();

        return ResponseEntity.ok(livrosDto);
    }

    @GetMapping("/editora")
    public ResponseEntity<List<LivroEscResponseDTO>> listarPorEditora(@RequestParam String editora) {
        List<Livro> livros = livroService.listarPorEditora(editora);

        List<LivroEscResponseDTO> livrosDto = livros.stream()
                .map(LivroMapper::toLivroEscritorDTO)
                .toList();

        return ResponseEntity.ok(livrosDto);
    }


    @GetMapping("/genero")
    public ResponseEntity<List<LivroEscResponseDTO>> listarPorGenero(@RequestParam String genero) {
        List<Livro> livros = livroService.listarPorGenero(genero);

        List<LivroEscResponseDTO> livrosDto = livros.stream()
                .map(LivroMapper::toLivroEscritorDTO)
                .toList();

        return ResponseEntity.ok(livrosDto);
    }

}
