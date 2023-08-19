package school.sptech.heroexercise;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {
    private List<Heroi> listaHerois = new ArrayList<>();

    @GetMapping
    public List<Heroi> listaHerois() {
        return listaHerois;
    }

    @GetMapping("/{indice}")
    public Heroi retornaHeroi(@PathVariable int indice) {
        if (indice > listaHerois.size() - 1 || indice < 0) {
            return null;
        } else {
            return listaHerois.get(indice);
        }
    }

    @GetMapping("/cadastrar/{nome}/{forca}/{habilidade}/{idade}/{vivo}")
    public Heroi cadastrarHeroi(@PathVariable String nome, @PathVariable int forca, @PathVariable String habilidade,
                                @PathVariable int idade, @PathVariable boolean vivo) {

        Heroi heroi = new Heroi(nome, forca, habilidade, idade, vivo);

        listaHerois.add(heroi);

        return heroi;
    }

    @GetMapping("/atualizar/{indice}/{nome}/{forca}/{habilidade}/{idade}/{vivo}")
    // atualiza os dados do herói na posição "indice" da lista e retorna o JSON novo dele.
    public Heroi atualizarHeroi(@PathVariable int indice, @PathVariable String nome, @PathVariable String habilidade,
                                @PathVariable int idade, @PathVariable int forca, @PathVariable boolean vivo) {
        if (indice > listaHerois.size() - 1 || indice < 0) {
            return null;
        } else {
            Heroi heroi = new Heroi(nome, forca, habilidade, idade, vivo);

            listaHerois.set(indice, heroi);

            return heroi;
        }
    }

    @GetMapping("/remover/{indice}")
    public String removerHeroi(@PathVariable int indice) {
        if (indice > listaHerois.size() - 1 || indice < 0) {
            return "Herói não encontrado!";
        } else {
            listaHerois.remove(indice);

            return "Herói removido com sucesso!";
        }
    }
}
