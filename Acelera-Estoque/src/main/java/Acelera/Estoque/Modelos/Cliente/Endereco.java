package Acelera.Estoque.Modelos.Cliente;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    //Classe que ira ser utilizada para uso da API viaCEP

    private String rua;
    private String bairro;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.rua = dados.rua();
        this.bairro = dados.bairro();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.rua() != null) {
            this.rua = dados.rua();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.uf() != null) {
            this.uf = dados.uf();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
    }
}
