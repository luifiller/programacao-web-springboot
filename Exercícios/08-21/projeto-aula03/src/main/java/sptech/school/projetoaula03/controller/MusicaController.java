package sptech.school.projetoaula03.controller;

import org.springframework.web.bind.annotation.*;
import sptech.school.projetoaula03.entity.Musica;

import java.util.ArrayList;
import java.util.List;

// @Controller MVC -> retorna páginas em html
@RestController // API em Rest -> retorna JSON
@RequestMapping("/musicas")
public class MusicaController {
    private List<Musica> musicas = new ArrayList<>();

    /*
    * Usar verbos da lingua portuguesa não é uma boa prática
    * Se tiver a necessidade de especificar a URI, usar substantivo
    * */
    @GetMapping
    public List<Musica> listar() {
        return this.musicas;
    }

    @GetMapping("/{indice}")
    public Musica consultarPorIndice(@PathVariable int indice) {
        if (indice >= 0 && indice < this.musicas.size()) {
            return this.musicas.get(indice);
        }

        return null;
    }

    @PostMapping
    public Musica cadastrar(@RequestBody Musica novaMusica) {
        this.musicas.add(novaMusica);

        return novaMusica;
    }


    @PostMapping("/todos")
    public List<Musica> cadastrarTodos(@RequestBody List<Musica> novaMusica) {
        this.musicas.addAll(novaMusica);

        return novaMusica;
    }

    @PutMapping("/{indice}")
    public Musica atualizar(@PathVariable int indice, @RequestBody Musica novaMusica) {
        if (indice >= 0 && indice < this.musicas.size()) {
            this.musicas.set(indice, novaMusica);

            return novaMusica;
        }

        return null;
    }

    @DeleteMapping("/{indice}")
    public String deletar(@PathVariable int indice) {
        if (indice >= 0 && indice < this.musicas.size()) {
            this.musicas.remove(indice);

            return "Música removida com sucesso";
        }

        return "Música não encontrada";
    }

}
