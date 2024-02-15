package Acelera.Estoque.Modelos.Produto;

import Acelera.Estoque.Modelos.Cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    Produto findByNome(String Nome);

}
