package biblioteca.biblioteca.sptech.school.repository;

import biblioteca.biblioteca.sptech.school.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
