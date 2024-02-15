package Acelera.Estoque.Controller;


import Acelera.Estoque.Modelos.Cliente.Cliente;
import Acelera.Estoque.Modelos.Cliente.DadosAtualizarCliente;
import Acelera.Estoque.Modelos.Cliente.DadosCadastroCliente;
import Acelera.Estoque.Modelos.Produto.DadosAtualizarProduto;
import Acelera.Estoque.Modelos.Produto.DadosCadastroProdutos;
import Acelera.Estoque.Modelos.Produto.Produto;
import Acelera.Estoque.Modelos.Produto.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroProdutos dados ){
        System.out.println(dados);
        repository.save(new Produto(dados));
    }

    @GetMapping
    public Page<Produto> listar (@PageableDefault(sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao);
    }

    @GetMapping("/{nome}")
    public Produto listarProdutoNome (@PathVariable String nome){
        return repository.findByNome(nome);
    }

    @PutMapping
    @Transactional
    public void atualizar (@RequestBody @Valid DadosAtualizarProduto dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarDados(dados);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir (@PathVariable Long id){
        repository.deleteById(id);
    }

}
