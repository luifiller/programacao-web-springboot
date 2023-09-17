package sptech.school.aula06.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sptech.school.aula06.jpa.entity.RegistroFinanceiro;

@Repository
// no extends deve indicar a classe e o tipo do id que é utilizado
public interface IRegistroFinanceiroRepository extends JpaRepository<RegistroFinanceiro, Integer> {
}
