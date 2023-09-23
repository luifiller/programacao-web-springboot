package sptech.school.filmesexercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sptech.school.filmesexercicio.entity.Filme;

@Repository
public interface IFilmesRepository extends JpaRepository<Filme, Integer> {

}
