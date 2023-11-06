package biblioteca.biblioteca.sptech.school.controller;

import biblioteca.biblioteca.sptech.school.dto.escritor.EscritorLivroResponseDTO;
import biblioteca.biblioteca.sptech.school.dto.escritor.EscritorRequestDTO;
import biblioteca.biblioteca.sptech.school.dto.escritor.LivroEscritorResponseDTO;
import biblioteca.biblioteca.sptech.school.dto.livro.LivroEscResponseDTO;
import biblioteca.biblioteca.sptech.school.dto.livro.LivroRequestDTO;
import biblioteca.biblioteca.sptech.school.entity.Escritor;
import biblioteca.biblioteca.sptech.school.entity.Livro;
import biblioteca.biblioteca.sptech.school.mapper.EscritorMapper;
import biblioteca.biblioteca.sptech.school.mapper.LivroMapper;
import biblioteca.biblioteca.sptech.school.repository.EscritorRepository;
import biblioteca.biblioteca.sptech.school.service.EscritorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/escritores")
public class EscritorController {
    private final EscritorService escritorService;
    private final EscritorMapper escritorMapper;

    @GetMapping
    public ResponseEntity<List<EscritorLivroResponseDTO>> findAll() {
        List<Escritor> all = escritorService.listarEscritores();

        if (all.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<EscritorLivroResponseDTO> escritoresDTOs = all.stream()
                .map(EscritorMapper::toEscritorLivroDTO)
                .toList();

        return ResponseEntity.ok(escritoresDTOs);
    }

    @PostMapping
    public ResponseEntity<EscritorLivroResponseDTO> cadastrar(@RequestBody @Valid EscritorRequestDTO escritor) {
        Escritor escritor2 = escritorMapper.toEntity(escritor);

        this.escritorService.cadastrarEscritor(escritor2);

        return ResponseEntity.ok(EscritorMapper.toEscritorLivroDTO(escritor2));
    }

    @PutMapping("/inserir-livro")
    public ResponseEntity<LivroEscResponseDTO> inserirLivro(@RequestParam int idLivro, @RequestParam int idEscritor) {
        Livro livro = escritorService.inserirLivro(idLivro, idEscritor);

        return ResponseEntity.ok(LivroMapper.toLivroEscritorDTO(livro));
    }

    @GetMapping("/mais-velho")
    public ResponseEntity<EscritorLivroResponseDTO> escritorMaisVelho() {
        Escritor escritor = escritorService.encontrarMaisVelho();

        return ResponseEntity.ok(EscritorMapper.toEscritorLivroDTO(escritor));
    }

    @GetMapping("/mais-publicacoes")
    public ResponseEntity<List<EscritorLivroResponseDTO>> escritorComMaisPublicacoes() {
        List<Escritor> escritor = escritorService.encontrarEscritoresComMaisPublicacoes();

        if (escritor.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(escritor.stream().map(EscritorMapper::toEscritorLivroDTO).toList());
    }

    @GetMapping("/nacionalidade")
    public ResponseEntity<List<EscritorLivroResponseDTO>> escritorComMaisPublicacoes(@RequestParam String nacionalidade) {
        List<Escritor> escritor = escritorService.encontrarPorNacionalidade(nacionalidade);

        if (escritor.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(escritor.stream().map(EscritorMapper::toEscritorLivroDTO).toList());
    }
}
