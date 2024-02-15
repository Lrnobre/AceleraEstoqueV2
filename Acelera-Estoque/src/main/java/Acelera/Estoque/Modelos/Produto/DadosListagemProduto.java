package Acelera.Estoque.Modelos.Produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosListagemProduto(Long id, String nome,  BigDecimal preco) {

    public DadosListagemProduto (Produto produto){
        this(produto.getId(),produto.getNome(), produto.getPreco());
    }

}
