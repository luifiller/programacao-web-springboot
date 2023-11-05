package biblioteca.biblioteca.sptech.school.controller;

import biblioteca.biblioteca.sptech.school.dto.livro.LivroEscritorDTO;
import biblioteca.biblioteca.sptech.school.entity.Livro;
import biblioteca.biblioteca.sptech.school.mapper.LivroMapper;
import biblioteca.biblioteca.sptech.school.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {
    private final LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroEscritorDTO>> findAll() {
        List<Livro> livros = livroService.listarTodos();

        List<LivroEscritorDTO> livrosDto = livros.stream()
                .map(LivroMapper::toLivroEscritorDTO)
                .toList();


        return ResponseEntity.ok(null);
    }

}
