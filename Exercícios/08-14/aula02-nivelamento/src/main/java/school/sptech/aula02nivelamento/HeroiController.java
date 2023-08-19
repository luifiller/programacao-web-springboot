package school.sptech.aula02nivelamento;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

    private List<Heroi> listaHerois = new ArrayList<>(
            List.of(
                    new Heroi("Aquaman", 100,
                            "Comunicação com animais marinhos", 35, true),
                    new Heroi("Batman", 100, "Dinheiro", 35, true)
            ));

    /*
     * Deserialização: transforma um JSON em um objeto
     * O "Jackson" formata um JSON para um objeto utilizando todos os getters
     * */

    /*
     * Serialização: transformar um objeto em um JSON
     * */
    @GetMapping("/favorito")
    public Heroi favorito() {
        return new Heroi("Aquaman", 100,
                "Comunicação com animais marinhos", 35, true);
    }

    @GetMapping
    public List<Heroi> listaHerois() {
        return listaHerois;
    }
}
