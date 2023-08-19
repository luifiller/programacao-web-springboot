package school.sptech.aula02nivelamento;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculos")
public class CalculoController {

    private Integer contador = 0;

    @GetMapping("/somar/{n1}/{n2}")
    public Integer somar(@PathVariable Integer n1, @PathVariable Integer n2) {
        return n1 + n2;
    }

    @GetMapping("/contador")
    public int contador() {
        return ++contador;
    }

    @GetMapping("/outro-contador")
    public int outroContador() {
        return ++contador;
    }
}