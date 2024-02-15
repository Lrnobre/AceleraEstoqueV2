package Acelera.Estoque.Controller;

import Acelera.Estoque.Modelos.Quantidade.DadosCadastroQuantidade;
import Acelera.Estoque.Modelos.Quantidade.QuantidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quantidades")
public class QuantidadesController {

    @Autowired
    private QuantidadeService quantidadeService;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroQuantidade dados) {
        quantidadeService.cadastrar(dados);
        return ResponseEntity.noContent().build();
    }

}
