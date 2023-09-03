package school.sptech.aula04revisaohttp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {

  private List<Heroi> herois = new ArrayList<>();

  @GetMapping
  public ResponseEntity<List<Heroi>> listar() {
    if (herois.isEmpty()) {
      return ResponseEntity.status(204).build();
    }

    return ResponseEntity.status(200).body(herois);
  }

  @PostMapping
  public ResponseEntity<Heroi> cadastrar(@RequestBody Heroi novoHeroi) {
    boolean isNomeValid = novoHeroi.getNome() != null && novoHeroi.getNome().trim().length() >= 3;
    boolean isHabilidadeValid = novoHeroi.getHabilidade() != null && novoHeroi.getHabilidade().trim().length() >= 3;
    boolean isIdadeValid = novoHeroi.getIdade() > 0;
    boolean isForcaValid = novoHeroi.getForca() > 0 && novoHeroi.getForca() < 100;

    if (isNomeValid && isHabilidadeValid && isIdadeValid && isForcaValid) {
      for (int i = 0; i < herois.size(); i++) {
        if (novoHeroi.getNome().equals(herois.get(i).getNome())) {
            Heroi h = herois.get(i);
            h.setHabilidade(novoHeroi.getHabilidade());
            h.setIdade(novoHeroi.getIdade());
            h.setForca(novoHeroi.getForca());

          return ResponseEntity.status(200).body(h);
        }
      }

      herois.add(novoHeroi);
      return ResponseEntity.status(201).body(novoHeroi);
    }

    return ResponseEntity.status(400).build();
  }

  @PutMapping("/{indice}")
  public ResponseEntity<Heroi> atualizar(@PathVariable int indice, @RequestBody Heroi heroi) {
    boolean isNomeValid = heroi.getNome() != null && heroi.getNome().trim().length() >= 3;
    boolean isHabilidadeValid = heroi.getHabilidade() != null && heroi.getHabilidade().trim().length() >= 3;
    boolean isIdadeValid = heroi.getIdade() > 0;
    boolean isForcaValid = heroi.getForca() > 0 && heroi.getForca() < 100;
    boolean isIndiceValid = indice >= 0 && indice < herois.size();

    if (isNomeValid && isHabilidadeValid && isIdadeValid && isForcaValid && isIndiceValid) {
      herois.set(indice, heroi);
      return ResponseEntity.status(200).body(heroi);
    }

    if (!isIndiceValid) {
      return ResponseEntity.status(404).build();
    }

    return ResponseEntity.status(400).build();
  }

  @DeleteMapping("/{indice}")
  public ResponseEntity<Void> deletar(@PathVariable int indice) {
    boolean isIndiceValid = indice >= 0 && indice < herois.size();

    if (isIndiceValid) {
      herois.remove(indice);
      return ResponseEntity.status(204).build();
    }

      return ResponseEntity.status(404).build();
  }
}
