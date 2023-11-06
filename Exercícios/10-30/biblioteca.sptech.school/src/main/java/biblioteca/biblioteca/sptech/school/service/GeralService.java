package biblioteca.biblioteca.sptech.school.service;

import biblioteca.biblioteca.sptech.school.entity.Escritor;
import biblioteca.biblioteca.sptech.school.entity.Livro;
import biblioteca.biblioteca.sptech.school.repository.EscritorRepository;
import biblioteca.biblioteca.sptech.school.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class GeralService {
    private final EscritorRepository escritorRepository;
    private final LivroRepository livroRepository;

    public Escritor findEscritor(int id) {
        return escritorRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Escritor não encontrado.")
                );
    }

    public Livro findLivro(int id) {
        return livroRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado.")
                );
    }
}
