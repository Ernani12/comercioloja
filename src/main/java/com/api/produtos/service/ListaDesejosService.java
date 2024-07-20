package com.api.produtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.produtos.model.ListaDesejos;
import com.api.produtos.model.Produto;
import com.api.produtos.repository.ListaDesejosRepository;
import com.api.produtos.repository.ProdutoRepository;

@Service
public class ListaDesejosService {

    @Autowired
    private ListaDesejosRepository listaDesejosRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public ListaDesejos getListaDesejosPorClienteId(String clienteId) {
        return listaDesejosRepository.findByClienteId(clienteId).orElse(new ListaDesejos(clienteId));
    }

    public ListaDesejos adicionarProduto(String clienteId, String produtoId) {
        ListaDesejos listaDesejos = getListaDesejosPorClienteId(clienteId);
        Produto produto = produtoRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        listaDesejos.addProduto(produto);
        return listaDesejosRepository.save(listaDesejos);
    }

    public ListaDesejos removerProduto(String clienteId, String produtoId) {
        ListaDesejos listaDesejos = getListaDesejosPorClienteId(clienteId);
        Produto produto = produtoRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        listaDesejos.getProdutos().remove(produto);
        return listaDesejosRepository.save(listaDesejos);
    }

    
}