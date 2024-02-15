package Acelera.Estoque.Modelos.Cliente;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test @DisplayName("Deve devolver erro por não reconhecer o cpf inserido")
    void existsByCpfCenario1() {
        var cpfInvalido = clienteRepository.existsByCpf("123456");
        assertThat(cpfInvalido).isFalse();
    }


}