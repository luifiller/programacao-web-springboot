package biblioteca.biblioteca.sptech.school.repository;

import biblioteca.biblioteca.sptech.school.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
    List<Livro> findLivrosByNomeContainingIgnoreCase(String nome);

    List<Livro> findLivrosByEditoraContainingIgnoreCase(String editora);

    List<Livro> findLivrosByGeneroContainingIgnoreCase(String genero);
}
