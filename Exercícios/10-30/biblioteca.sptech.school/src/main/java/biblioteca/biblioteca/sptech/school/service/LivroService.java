package biblioteca.biblioteca.sptech.school.service;

import biblioteca.biblioteca.sptech.school.entity.Livro;
import biblioteca.biblioteca.sptech.school.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository livroRepository;

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public List<Livro> listarPorNome(String nome) {
        return livroRepository.findLivrosByNomeContainingIgnoreCase(nome);
    }

    public List<Livro> listarPorEditora(String editora) {
        return livroRepository.findLivrosByEditoraContainingIgnoreCase(editora);
    }

    public List<Livro> listarPorGenero(String genero) {
        return livroRepository.findLivrosByGeneroContainingIgnoreCase(genero);
    }
}
