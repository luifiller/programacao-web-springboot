package school.sptech.aula02nivelamento;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
* O "@" é funcionalidade do Java e do Spring chamada "notação",
* elas possibilitam a metaprogramação, ou seja, utilizar funcionalidades
* já desenvolvidas por outras pessoas e que são importadas na classe e projeto.
* Essa notação é semelhante ao Decorator no TypeScript.
* */
@RestController
@RequestMapping("/frases")
/*
 * Este "/frases" é uma URI, também chamada de endpoint
 * Geralmente o @RequestMapping sempre terá o URI no plural
 * */

public class FraseController {

    private List<String> listaFrases = new ArrayList<>();

    @GetMapping("/contagem-frases")
    public String retornaContagemFrases() {
        listaFrases.add("Arroba");
        listaFrases.add("Joka");

        return String.format("""
                VOcê tem %s frases cadastradas
                """, listaFrases.size());
    }

    //https://localhost:8080/frases
    @GetMapping
    public String frase() {
        return "Hello world!";
    }

    @GetMapping("/saudacao")
    public String saudacao() {
        return "Olá, mundo!";
    }

    /*
    * O @PathVariable serve para fazer a filtragem única de um parâmetro
    * */
    @GetMapping("personalizada/{nome}")
    public String personalizada(@PathVariable String nome) {
        return String.format("""
                Boa tarde, %s!
                Você é um programador.
                """, nome);
    }

    @GetMapping("personalizada/{nome}/{sobrenome}")
    public String personalizada(@PathVariable String nome, @PathVariable String sobrenome) {
        return String.format("""
                Boa tarde, %s %s!
                Você é um programador.
                """, nome, sobrenome);
    }
}
