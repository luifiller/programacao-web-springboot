package sptech.school.aula05exercicios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.aula05exercicios.entity.Futebol;

import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/times")
public class FutebolController {
    List<Futebol> times = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Futebol> cadastrar(@RequestBody Futebol novoTime) {
        boolean isNomeValid = novoTime.getNome().trim().length() >= 3 && novoTime.getNome() != null && !novoTime.getNome().isBlank();
        boolean isTreinadorValid = novoTime.getTreinador().trim().length() >= 2 && novoTime.getTreinador() != null && !novoTime.getTreinador().isBlank();

        if (!isNomeValid || !isTreinadorValid) {
            return ResponseEntity.status(400).build();
        }

        times.add(novoTime);
        return  ResponseEntity.status(201).body(novoTime);
    }

    @GetMapping
    public ResponseEntity<List<Futebol>> listarTimes() {
        if (times.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(times);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Futebol> listarTime(@PathVariable int indice) {
        boolean isIndiceValid = indice >= 0 && indice < times.size();

        if (times.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else if (!isIndiceValid) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(times.get(indice));
    }

    @PostMapping("/{indice}/registrar-vitoria")
    public ResponseEntity<List<Futebol>> registrarVitoria(@PathVariable int indice){
        boolean isIndiceValid = indice >= 0 && indice < times.size();

        if (!isIndiceValid) {
            return ResponseEntity.status(404).build();
        }

        Futebol timeEscolhido = times.get(indice);
        timeEscolhido.setVitorias(timeEscolhido.getVitorias() + 1);
        return ResponseEntity.status(200).body(times);
    }

    @PostMapping("/{indice}/registrar-derrota")
    public ResponseEntity<List<Futebol>> registrarDerrota(@PathVariable int indice){
        boolean isIndiceValid = indice >= 0 && indice < times.size();

        if (!isIndiceValid) {
            return ResponseEntity.status(404).build();
        }

        Futebol timeEscolhido = times.get(indice);
        timeEscolhido.setDerrotas(timeEscolhido.getDerrotas() + 1);
        return ResponseEntity.status(200).body(times);
    }

    @PostMapping("/{indice}/registrar-empate")
    public ResponseEntity<List<Futebol>> registrarEmpate(@PathVariable int indice){
        boolean isIndiceValid = indice >= 0 && indice < times.size();

        if (!isIndiceValid) {
            return ResponseEntity.status(404).build();
        }

        Futebol timeEscolhido = times.get(indice);
        timeEscolhido.setEmpates(timeEscolhido.getEmpates() + 1);
        return ResponseEntity.status(200).body(times);
    }
}
