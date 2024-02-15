package Acelera.Estoque.Modelos.Cliente;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public record DadosCadastroCliente(
        @NotBlank
        String nome,
        @NotNull @Past @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dataNascimento,
        @NotBlank @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank @Pattern(regexp = "\\d{8}")
        String cep ) {
}
