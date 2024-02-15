package Acelera.Estoque.Modelos.Cliente;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String cep;


    public Cliente(DadosCadastroCliente dados) {
        this.nome = dados.nome();
        this.dataNascimento = dados.dataNascimento();
        this.cpf = dados.cpf();
        this.cep = dados.cep();
    }

    public void atualizarDados(DadosAtualizarCliente dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.dataNascimento() != null){
            this.dataNascimento = dados.dataNascimento();
        }
        if (dados.cpf() != null){
            this.cpf = dados.cpf();
        }
        if (dados.cep() != null){
            this.cep = dados.cep();
        }
    }

}
