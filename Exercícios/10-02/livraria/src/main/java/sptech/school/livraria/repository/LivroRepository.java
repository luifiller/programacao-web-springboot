package sptech.school.livraria.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import sptech.school.livraria.entity.Livro;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface LivroRepository extends JpaRepository<Livro, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Livro l set l.titulo = :titulo, l.autor = :autor WHERE l.id = :id")
    void atualizarTituloAutor(String titulo, String autor, Integer id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Livro l  WHERE l.id = :id")
    void deletarLivroPorId(Integer id);

    @Query("SELECT l FROM Livro l WHERE l.dataLancamento > :data")
    List<Livro> buscarLivrosNaoPublicados(LocalDate data);

    Optional<Livro> findLivroById(Integer id);

    List<Livro> findLivrosByDisponibilidadeEstoqueTrue();

    List<Livro> findTop5ByDataLancamentoLessThanEqualOrderByDataLancamentoDesc(LocalDate data);

    Livro findFirstByOrderByPrecoDesc();
}
