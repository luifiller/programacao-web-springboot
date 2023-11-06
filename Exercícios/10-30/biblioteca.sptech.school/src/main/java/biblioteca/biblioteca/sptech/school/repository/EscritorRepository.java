package biblioteca.biblioteca.sptech.school.repository;

import biblioteca.biblioteca.sptech.school.entity.Escritor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface EscritorRepository extends JpaRepository<Escritor, Integer> {
    Optional<Escritor> findFirstByOrderByIdadeDesc();

    List<Escritor> findTop3ByOrderByQuantidadePublicacoesDesc();

    List<Escritor> findEscritorsByNacionalidadeEqualsIgnoreCase(String nacionalidade);
}
