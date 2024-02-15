package Acelera.Estoque.Controller;

import Acelera.Estoque.Modelos.Cliente.Cliente;
import Acelera.Estoque.Modelos.Cliente.ClienteRepository;
import Acelera.Estoque.Modelos.Cliente.DadosAtualizarCliente;
import Acelera.Estoque.Modelos.Cliente.DadosCadastroCliente;
import Acelera.Estoque.Modelos.Produto.Produto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid  DadosCadastroCliente dados ){

        repository.save(new Cliente(dados));
    }

    @GetMapping
    public Page<Cliente> listarCliente (@PageableDefault(sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao);
    }

    @GetMapping("/{cpf}")
    public Cliente listarProdutoNome (@PathVariable String cpf){
        return repository.findByCpf(cpf);
    }


    @PutMapping
    @Transactional
    public void atualizar (@RequestBody @Valid DadosAtualizarCliente dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarDados(dados);

    }



    @DeleteMapping("/{id}")
    @Transactional
    public void excluir (@PathVariable Long id){
        repository.deleteById(id);
    }

}
