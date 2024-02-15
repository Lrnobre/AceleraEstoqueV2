package Acelera.Estoque.Modelos.Quantidade;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record DadosCadastroQuantidade(

        @NotNull
        Long idProduto,
        @NotNull
        @Future
        LocalDate mesReferente,
        @NotNull
        Integer quantidade

) {
}
