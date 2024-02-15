package Acelera.Estoque.Modelos.Produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "produtos")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private BigDecimal preco;


    public Produto(DadosCadastroProdutos dados) {
        this.nome = dados.nome();
        this.preco = dados.preco();
    }

    public void atualizarDados(DadosAtualizarProduto dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.preco() != null){
            this.preco = dados.preco();
        }
    }
}
