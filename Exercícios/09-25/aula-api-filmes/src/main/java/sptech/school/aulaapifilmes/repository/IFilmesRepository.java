package sptech.school.aulaapifilmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sptech.school.aulaapifilmes.entity.Filme;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IFilmesRepository extends JpaRepository<Filme, Integer> {
    // Like %s%, ignorando case
    List<Filme> findByNomeContainsIgnoreCase(String nome);
    List<Filme> findByDataLancamentoLessThanEqual(LocalDate data);
    List<Filme> findByIndicacaoOscarIsTrue();
    int countByIndicacaoOscarFalse();

    Optional<Filme> findFirstByOrderByCustoProducaoDesc();
}
