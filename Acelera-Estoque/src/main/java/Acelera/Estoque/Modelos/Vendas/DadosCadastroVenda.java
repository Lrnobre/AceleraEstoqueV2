package Acelera.Estoque.Modelos.Vendas;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record DadosCadastroVenda(

        @NotNull
        Long idProduto,

        String cpf,
        @NotNull
        @PastOrPresent
        LocalDate dataVenda,
        @NotNull
        Integer quantidade


) {
}
