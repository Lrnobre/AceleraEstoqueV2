package Acelera.Estoque.Modelos.Cliente;

import Acelera.Estoque.Modelos.Cliente.Cliente;
import Acelera.Estoque.Modelos.Produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByCpf(String cpf);

    Cliente findByCpf(String cpf);


}
