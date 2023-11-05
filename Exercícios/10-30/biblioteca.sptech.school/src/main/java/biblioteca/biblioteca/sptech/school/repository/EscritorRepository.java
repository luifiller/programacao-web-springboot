package biblioteca.biblioteca.sptech.school.repository;

import biblioteca.biblioteca.sptech.school.entity.Escritor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EscritorRepository extends JpaRepository<Escritor, Long> {

}
