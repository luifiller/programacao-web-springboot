package exercicio.preparacaoprova.repository;

import exercicio.preparacaoprova.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, UUID> {


    //1. Buscar musicas por nome do artista (valor exato)
    List<Musica> findMusicasByArtistaEquals(String artista);

    //2. Buscar musicas por parte do nome (valor parcial) ignore case
    List<Musica> findMusicasByNomeContainsIgnoreCase(String nome);

    //3. Contar todas as musicas de um genero (JQPL - valor exato)
    @Query("SELECT COUNT(m) FROM Musica m WHERE m.genero = :genero")
    Integer countMusicasByGeneroEquals(String genero);

    //4. Buscar musicas não lançadas
    List<Musica> findMusicasByDataLancamentoAfter(LocalDate dataLancamento);

    //5. Buscar musicas já lancadas
    List<Musica> findMusicasByDataLancamentoLessThanEqual(LocalDate dataLancamento);

    //6. Buscar musica com mais acessos (quantidade de acessos)
    Optional<Musica> findFirstByOrderByAcessosDesc();

    //7. Buscar top 3 musicas com maior nota
    List<Musica> findTop3ByOrderByNotaDesc();

    //8. Buscar total de acessos a partir de um gênero (JPQL - valor exato - SUMARIZACAO)
    @Query("SELECT SUM(m.acessos) FROM Musica m WHERE m.genero = :genero")
    Integer countAcessosByGenero(String genero);

    //9. Buscar APENAS UMA musica com menor nota (JQPL)
    @Query("SELECT m FROM Musica m ORDER BY m.nota ASC LIMIT 1")
    Musica findMusicaByMenorNota();
}
