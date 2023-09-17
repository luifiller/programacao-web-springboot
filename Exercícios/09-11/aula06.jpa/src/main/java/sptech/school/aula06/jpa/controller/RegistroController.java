package sptech.school.aula06.jpa.controller;

import jdk.javadoc.doclet.Reporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.aula06.jpa.entity.RegistroFinanceiro;
import sptech.school.aula06.jpa.repository.IRegistroFinanceiroRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registros")
public class RegistroController {
    @Autowired
    private IRegistroFinanceiroRepository repository;

    private List<RegistroFinanceiro> registros = new ArrayList<>();

    @PostMapping
    public ResponseEntity<RegistroFinanceiro> cadastrar(@RequestBody RegistroFinanceiro novoRegistro) {
        boolean isRegistroValid = novoRegistro != null;

        if (!isRegistroValid) {
            return ResponseEntity.status(400).build();
        }

        // registros.add(novoRegistro);
        RegistroFinanceiro registroSalvo = this.repository.save(novoRegistro);
        return ResponseEntity.status(201).body(novoRegistro);
    }

    @GetMapping
    public ResponseEntity<List<RegistroFinanceiro>> listar() {
        List<RegistroFinanceiro> registros = this.repository.findAll();

        if (registros.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(registros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroFinanceiro> listar(@PathVariable int id) {
        Optional<RegistroFinanceiro> registroOpt = this.repository.findById(id);

        if (registroOpt.isPresent()) {
            RegistroFinanceiro registroFinanceiro = registroOpt.get();
            return ResponseEntity.status(200).body(registroFinanceiro);
        }

        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroFinanceiro> atualizar(@PathVariable int id, @RequestBody RegistroFinanceiro registro) {

        if (registros.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        registro.setId(id);

        if (this.repository.existsById(id)) {
            RegistroFinanceiro registroAtualizado = this.repository.save(registro);
        }


        // SAVE
        // Se objeto não possui ID -> ele cria um registro
        // Se objeto possui ID -> ele atualiza o registro
        // registros.set(id, registro);

        return ResponseEntity.status(200).body(registro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RegistroFinanceiro> deletar(@PathVariable int id) {
        boolean isIndiceValid = id >= 0 && id < registros.size();


        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return ResponseEntity.status(204).build();
        }

        if (!isIndiceValid) {
            return ResponseEntity.status(404).build();
        }

        registros.remove(id);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/ganhos")
    public ResponseEntity<List<RegistroFinanceiro>> listarGanhos() {
        List<RegistroFinanceiro> registrosPositivos = new ArrayList<>();
        if (registros.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        for (RegistroFinanceiro r : registros) {
            if (r.getValor() > 0.0) {
                registrosPositivos.add(r);
            }
        }

        if (registrosPositivos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(registrosPositivos);
    }

    @GetMapping("/despesas")
    public ResponseEntity<List<RegistroFinanceiro>> listarDespesas() {
        List<RegistroFinanceiro> registrosNegativos = new ArrayList<>();

        if (registros.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        for (RegistroFinanceiro r : registros) {
            if (r.getValor() < 0.0) {
                registrosNegativos.add(r);
            }
        }

        if (registrosNegativos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(registrosNegativos);
    }
}
