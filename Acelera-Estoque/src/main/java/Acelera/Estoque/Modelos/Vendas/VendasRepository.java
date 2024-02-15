package Acelera.Estoque.Modelos.Vendas;

import Acelera.Estoque.Modelos.Cliente.Cliente;
import Acelera.Estoque.Modelos.Produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface VendasRepository extends JpaRepository<Venda, Long > {
}
