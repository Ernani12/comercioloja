package com.api.produtos;

import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.api.produtos.model.Produto;
import com.api.produtos.repository.ProdutoRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@SpringBootTest
class ProdutosApplicationTests {

	@Autowired
    private ProdutoRepository produtoRepository;

    private Produto produto;

    @Given("o produto com nome {string} e preço {double}")
    public void o_produto_com_nome_e_preco(String nome, Double preco) {
        produto = new Produto();
        produto.setNome(nome);
        produto.setPreco(preco);
    }

    @When("eu adicionar o produto")
    public void eu_adicionar_o_produto() {
        produto = produtoRepository.save(produto);
    }

    @Then("o produto deve ser salvo no sistema")
    public void o_produto_deve_ser_salvo_no_sistema() {
        assertNotNull(produto.getCodigo());
    }
}
