package Acelera.Estoque.Modelos.Cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DadosAtualizarCliente(
        @NotNull
        Long id,
        String nome,
        @Past
        LocalDate dataNascimento,
        @Pattern(regexp = "\\d{11}")
        String cpf,
        @Pattern(regexp = "\\d{8}")
        String cep) {
}
