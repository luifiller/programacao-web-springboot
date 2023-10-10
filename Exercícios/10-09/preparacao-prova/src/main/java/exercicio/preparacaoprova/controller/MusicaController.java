package exercicio.preparacaoprova.controller;

import exercicio.preparacaoprova.entity.Musica;
import exercicio.preparacaoprova.repository.MusicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
@RestController
@RequestMapping("/musicas")
public class MusicaController {

    private final MusicaRepository repository;

    @GetMapping
    public ResponseEntity<List<Musica>> listagemGeral() {
        List<Musica> listagem = this.repository.findAll();

        if (listagem.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(listagem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> buscarPorId(@PathVariable UUID id) {
        Optional<Musica> musicaOpt = this.repository.findById(id);

        return ResponseEntity.of(musicaOpt);
    }

    @GetMapping("/artista")
    public ResponseEntity<List<Musica>> buscarPorArtista(@RequestParam String nome) {
        List<Musica> listagem = this.repository.findMusicasByArtistaEquals(nome);

        if (listagem.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(listagem);
    }

    @GetMapping("/nome")
    public ResponseEntity<List<Musica>> buscarPorTitulo(@RequestParam String titulo) {
        List<Musica> listagem = this.repository.findMusicasByNomeContainsIgnoreCase(titulo);

        if (listagem.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(listagem);
    }

    @GetMapping("/genero/contagem")
    public ResponseEntity<Integer> contarPorGenero(@RequestParam String nome) {
        Integer quantidade = this.repository.countMusicasByGeneroEquals(nome);

        return ResponseEntity.ok().body(quantidade);
    }

    @GetMapping("/nao-lancadas")
    public ResponseEntity<List<Musica>> buscarNaoLancadas(@RequestParam LocalDate data) {
        List<Musica> listagem = this.repository.findMusicasByDataLancamentoAfter(data);

        if (listagem.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(listagem);
    }

    @GetMapping("/lancadas")
    public ResponseEntity<List<Musica>> buscarLancadas() {
        List<Musica> lisagem = this.repository.findMusicasByDataLancamentoLessThanEqual(LocalDate.now());

        if (lisagem.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(lisagem);
    }

    @GetMapping("/mais-acessos")
    public ResponseEntity<Musica> buscarMaisPopular() {
        Optional<Musica> musicaOpt = this.repository.findFirstByOrderByAcessosDesc();

        return ResponseEntity.of(musicaOpt);
    }

    @GetMapping("/top3-notas")
    public ResponseEntity<List<Musica>> buscarTop3MaioresNotas() {
        List<Musica> top3 = this.repository.findTop3ByOrderByNotaDesc();

        if (this.repository.findAll().isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(top3);
    }

    @GetMapping("/genero/acessos/contagem")
    public ResponseEntity<Integer> buscarQuantidadeAcessosPorGenero(@RequestParam String nome) {
        List<Musica> listagem = this.repository.findAll();
        Integer countAcessos = this.repository.countAcessosByGenero(nome);

        if (listagem.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(countAcessos);
    }

    @GetMapping("/menor-nota")
    public ResponseEntity<Musica> buscarMenorNota() {
        List<Musica> listagem = this.repository.findAll();
        Musica musicaMenorNota = this.repository.findMusicaByMenorNota();


        if (listagem.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(musicaMenorNota);
    }
}
