package sptech.school.validacoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.school.validacoes.entity.Musica;

// camada que vai lidar com o Banco de Dados
public interface IMusicaRepository extends JpaRepository<Musica, Integer> {

}
