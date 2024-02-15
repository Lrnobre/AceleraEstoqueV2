package Acelera.Estoque.Modelos.Produto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAtualizarProduto(
        @NotNull
        Long id,
        String nome,
        BigDecimal preco
) {
}
