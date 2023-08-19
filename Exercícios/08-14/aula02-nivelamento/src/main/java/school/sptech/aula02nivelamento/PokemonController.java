package school.sptech.aula02nivelamento;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private List<String> listaPokemons = new ArrayList<>();

    @GetMapping
    public String retornaTotalPokemonsCadastrados() {
        return String.format("""
                Você tem %d pokemons cadastrados!
                """, listaPokemons.size());
    }

    @GetMapping("/cadastrar/{pokemon}")
    public String cadastrarPokemon(@PathVariable String pokemon) {
        listaPokemons.add(pokemon);
        return String.format("""
                Pokemon %s cadastrado com sucesso!
                """, pokemon);
    }

    @GetMapping("/recuperar/{indice}")
    public String recuperarPokemon(@PathVariable Integer indice) {
        if (indice > listaPokemons.size() - 1 || indice < 0) {
            return String.format("""
                    Pokemon não encontrado! 
                    """);
        } else {
            return listaPokemons.get(indice);
        }
    }

    @GetMapping("/excluir/{indice}")
    public String excluirPokemon(@PathVariable int indice) {
        if (indice > listaPokemons.size() - 1 || indice < 0) {
            return String.format("""
                    Pokemon não encontrado!
                    """);
        } else {
            listaPokemons.remove(indice);

            return String.format("""
                    Pokemon excluído com sucesso!
                    %s
                    """, this.listaPokemons);
        }
    }

    @GetMapping("/atualizar/{indice}/{novoNome}")
    public String atualizarPokemon(@PathVariable Integer indice, @PathVariable String novoNome) {
        if (indice > listaPokemons.size() - 1 || indice < 0) {
            return String.format("""
                    Pokemon não encontrado!
                    """);
        } else {
            listaPokemons.set(indice, novoNome);

            return String.format("""
                    Pokemon atualizado com sucesso!
                    """);
        }
    }
}
