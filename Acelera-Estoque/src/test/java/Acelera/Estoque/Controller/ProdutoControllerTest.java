package Acelera.Estoque.Controller;

import Acelera.Estoque.Modelos.Produto.DadosCadastroProdutos;
import Acelera.Estoque.Modelos.Produto.DadosListagemProduto;
import Acelera.Estoque.Modelos.Produto.Produto;
import Acelera.Estoque.Modelos.Produto.ProdutoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Field;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.core.ResolvableType;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ProdutoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosListagemProduto> dadosListagemProduto;

    @Autowired
    private JacksonTester<DadosCadastroProdutos> dadosCadastroProdutos;

    @Autowired
    @MockBean
    private ProdutoRepository produtoRepository;


    @Test
    @DisplayName("Deve devolver erro 400 por não ter nenhum dado")
    void cadastrarCenario1() throws Exception {
       var response = mvc.perform(post("/produtos")).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deve devolver erro 200 quando as informações estão validas")
    void cadastrarCenario2() throws Exception {
        var dadosCadastro = new DadosCadastroProdutos("Cadeira", new BigDecimal(150));

        when(produtoRepository.save(any())).thenReturn(new Produto(dadosCadastro));

        var response = mvc
                .perform(post("/produtos").contentType(MediaType.APPLICATION_JSON).content
                        (dadosCadastroProdutos.write(dadosCadastro).getJson()))
                        .andReturn().getResponse();


        var dadosDetalhamento = new DadosListagemProduto(null,dadosCadastro.nome(),dadosCadastro.preco());
        var jsonEsperado = dadosListagemProduto.write(dadosDetalhamento).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);

    }


}