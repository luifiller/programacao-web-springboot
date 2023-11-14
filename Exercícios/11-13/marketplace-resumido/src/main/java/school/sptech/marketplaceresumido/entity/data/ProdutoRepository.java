package school.sptech.marketplaceresumido.entity.data;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.marketplaceresumido.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    boolean existsByCodigoBarraAndIdNot(String codigoBarra, Integer id);

    boolean existsByCodigoBarra(String codigoBarra);
}
