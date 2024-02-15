package Acelera.Estoque.Modelos.Vendas;

import Acelera.Estoque.Modelos.Cliente.Cliente;
import Acelera.Estoque.Modelos.Cliente.ClienteRepository;
import Acelera.Estoque.Modelos.Produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendasService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendasRepository repository;

    public void cadastrar(DadosCadastroVenda dados) {

        if(!produtoRepository.existsById(dados.idProduto())){
            throw new RuntimeException("Não existe esse produto");
        }

        if(!clienteRepository.existsByCpf(dados.cpf())){
            throw new RuntimeException("não existe esse cpf");
        }
        var produto = produtoRepository.findById(dados.idProduto()).get();
        var cliente = clienteRepository.findByCpf(dados.cpf());


        var venda = new Venda(null,produto,cliente,dados.dataVenda(), dados.quantidade());

        repository.save(venda);

    }
}
