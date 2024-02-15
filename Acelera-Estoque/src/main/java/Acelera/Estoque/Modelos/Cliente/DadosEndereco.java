package Acelera.Estoque.Modelos.Cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        String rua,
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        String uf
) {

}
