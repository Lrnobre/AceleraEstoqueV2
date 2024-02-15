package Acelera.Estoque.Modelos.Quantidade;

import Acelera.Estoque.Modelos.Produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuantidadeService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private QuantidadeRepository quantidadeRepository;

    public void cadastrar(DadosCadastroQuantidade dados){

        if(!produtoRepository.existsById(dados.idProduto())){
            throw new RuntimeException("Não existe esse produto");
        }

        var produto = produtoRepository.findById(dados.idProduto()).get();
        var quantidade = new Quantidade(null,produto,dados.mesReferente(),dados.quantidade());

        quantidadeRepository.save(quantidade);
    }

}
