

package com.api.produtos;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.produtos.model.Cliente;
import com.api.produtos.model.Produto;
import com.api.produtos.repository.ClienteRepository;
import com.api.produtos.repository.ProdutoRepository;

@SpringBootTest
public  class ProdutosApplicationTests {

	@Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    private Produto produto;
    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        produto = new Produto();
    }

    @Test
    public void dadoUmProdutoComNomeEPreco_deveSerSalvoNoSistema() {
        // Given
        produto.setNome("Produto Teste");
        produto.setPreco(10.0);

        // When
        produto = produtoRepository.save(produto);

        // Then
        assertThat(produto.getCodigo()).isNotNull();
    }

    @Test
    public void dadoUmProdutoExistente_comCodigoENomeEPreco_deveSerAtualizadoNoSistema() {
        // Given
        produto.setCodigo("123");
        produto.setNome("Produto Teste");
        produto.setPreco(10.0);
        produtoRepository.save(produto);

        // When
        produto.setNome("Produto Atualizado");
        produto.setPreco(20.0);
        produtoRepository.save(produto);

        // Then
        Produto atualizado = produtoRepository.findById(produto.getCodigo()).orElse(null);
        assertThat(atualizado).isNotNull();
        assertThat(atualizado.getNome()).isEqualTo("Produto Atualizado");
        assertThat(atualizado.getPreco()).isEqualTo(20.0);
    }

    @Test
    public void dadoUmProdutoExistente_comCodigo_deveSerDeletadoDoSistema() {
        // Given
        produto.setCodigo("123");
        produto.setNome("Produto Teste");
        produto.setPreco(10.0);
        produtoRepository.save(produto);

        // When
        produtoRepository.deleteById(produto.getCodigo());

        // Then
        Produto deletado = produtoRepository.findById(produto.getCodigo()).orElse(null);
        assertThat(deletado).isNull();
    }

    @Test
    public void dadoUmCliente_comNomeEEmail_deveSerSalvoNoSistema() {
        // Given
        cliente = new Cliente();
        cliente.setNome("Cliente Teste");
        cliente.setEmail("cliente@teste.com");

        // When
        cliente = clienteRepository.save(cliente);

        // Then
        assertThat(cliente.getId()).isNotNull();
    }

    @Test
    public void dadoUmClienteExistente_comId_deveSerRetornadoDoSistema() {
        // Given
        cliente = new Cliente();
        cliente.setNome("Cliente Teste");
        cliente.setEmail("cliente@teste.com");
        cliente = clienteRepository.save(cliente);

        // When
        Cliente encontrado = clienteRepository.findById(cliente.getId()).orElse(null);

        // Then
        assertThat(encontrado).isNotNull();
        assertThat(encontrado.getNome()).isEqualTo(cliente.getNome());
    }
}
