package RA01222167pratica.demo.controller;

import RA01222167pratica.demo.entity.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    List<Usuario> usuarios = new ArrayList<>();
    int ultimoIdCriado = 0;

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario novoUsuario) {
        boolean isEmailValid = novoUsuario.getEmail().contains("@")
                && novoUsuario.getEmail().trim().length() >= 10
                && novoUsuario.getEmail() != null
                && !novoUsuario.getEmail().isBlank();
        int novoId;

        if (!isEmailValid) {
            return ResponseEntity.status(400).build();
        }

        if (ultimoIdCriado > 0) {
            novoId = ultimoIdCriado + 1;
        } else if (usuarios.isEmpty() && ultimoIdCriado == 0) {
            novoId = 1;
        } else {
            novoId = usuarios.get(usuarios.size() - 1).getId();
            novoId++;
        }

        for (Usuario u: usuarios) {
            if (u.getEmail().equals(novoUsuario.getEmail())) {
                return ResponseEntity.status(400).build();
            }
        }

        ultimoIdCriado = novoId;
        novoUsuario.setId(novoId);
        usuarios.add(novoUsuario);

        return ResponseEntity.status(200).body(novoUsuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(usuarios);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Usuario> listarUsuario(@PathVariable int indice) {
        boolean isIndiceValid = indice >= 0 && indice < usuarios.size();

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else if (!isIndiceValid) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(usuarios.get(indice));
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Usuario> atualizar(@PathVariable int indice, @RequestBody Usuario usuarioAtualizado) {
        boolean isEmailValid = usuarioAtualizado.getEmail().contains("@")
                && usuarioAtualizado.getEmail().trim().length() >= 10
                && usuarioAtualizado.getEmail() != null
                && !usuarioAtualizado.getEmail().isBlank();
        boolean isIndiceValid = indice >= 0 && indice < usuarios.size();

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else if (!isEmailValid) {
            return ResponseEntity.status(400).build();
        } else if (!isIndiceValid) {
            return ResponseEntity.status(404).build();
        }

        for (Usuario u: usuarios) {
            if (u.getEmail().equals(usuarioAtualizado.getEmail())) {
                return ResponseEntity.status(400).build();
            }
        }

        usuarioAtualizado.setId(usuarios.get(indice).getId());
        usuarios.set(indice, usuarioAtualizado);
        return ResponseEntity.status(200).body(usuarioAtualizado);
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Void> deletar(@PathVariable int indice) {
        boolean indiceValido = indice >= 0 && indice < usuarios.size();

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else if (!indiceValido) {
            return ResponseEntity.status(404).build();
        }

        usuarios.remove(indice);
        return ResponseEntity.status(204).build();
    }
}
