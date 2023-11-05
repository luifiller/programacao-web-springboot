package biblioteca.biblioteca.sptech.school.controller;

import biblioteca.biblioteca.sptech.school.dto.escritor.EscritorLivroDTO;
import biblioteca.biblioteca.sptech.school.entity.Escritor;
import biblioteca.biblioteca.sptech.school.mapper.EscritorMapper;
import biblioteca.biblioteca.sptech.school.repository.EscritorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/escritores")
public class EscritorController {
    private final EscritorRepository escritorRepository;

    @GetMapping
    public ResponseEntity<List<EscritorLivroDTO>> findAll() {
        List<Escritor> all = escritorRepository.findAll();

        if (all.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<EscritorLivroDTO> escritoresDTOs = all.stream()
                .map(EscritorMapper::toEscritorLivroDTO)
                .toList();

        return ResponseEntity.ok(escritoresDTOs);
    }

    @GetMapping("/escritores")
    public ResponseEntity<List<Escritor>> listarTodos() {
        return ResponseEntity.ok(this.escritorRepository.findAll());
    }
}
