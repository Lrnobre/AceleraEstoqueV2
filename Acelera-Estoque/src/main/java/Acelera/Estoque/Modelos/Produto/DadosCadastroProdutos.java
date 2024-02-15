package Acelera.Estoque.Modelos.Produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCadastroProdutos(
        @NotBlank
        String nome,
        @NotNull
        BigDecimal preco
) {
}
