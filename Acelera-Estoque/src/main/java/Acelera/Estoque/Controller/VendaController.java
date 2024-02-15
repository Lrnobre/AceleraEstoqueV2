package Acelera.Estoque.Controller;

import Acelera.Estoque.Modelos.Quantidade.DadosCadastroQuantidade;
import Acelera.Estoque.Modelos.Vendas.DadosCadastroVenda;
import Acelera.Estoque.Modelos.Vendas.VendasRepository;
import Acelera.Estoque.Modelos.Vendas.VendasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vendas")
public class VendaController {

    @Autowired
    private VendasService vendasService;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroVenda dados) {
        vendasService.cadastrar(dados);
        return ResponseEntity.noContent().build();
    }

}
