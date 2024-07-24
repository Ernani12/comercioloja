package com.api.produtos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    private static final int MAX_SIZE = 20;


    public List<Produto> listarDesejos() {
        ListaDesejos listaDesejos = listaDesejosRepository.findById("lista_unica").orElse(new ListaDesejos());
        System.out.print("listado lista desejos");
        return listaDesejos.getProdutos();
    }

    public void adicionarProduto(String codigo) {
        Optional<Produto> produto = produtoRepository.findById(codigo);
        if (produto.isPresent()) {
            ListaDesejos listaDesejos = listaDesejosRepository.findById("lista_unica").orElse(new ListaDesejos("lista_unica", new ArrayList<>()));

            if (listaDesejos.getProdutos().size() >= MAX_SIZE) {
                throw new IllegalStateException("A lista de desejos atingiu o limite máximo de " + MAX_SIZE + " produtos.");
            }

            if (listaDesejos.getProdutos() == null) {
                listaDesejos.setProdutos(new ArrayList<>());
            }
            listaDesejos.getProdutos().add(produto.get());
            listaDesejosRepository.save(listaDesejos);
        }
    }

    public void removerProduto(String codigo) {
        ListaDesejos listaDesejos = listaDesejosRepository.findById("lista_unica").orElse(null);
        if (listaDesejos != null) {
            listaDesejos.getProdutos().removeIf(produto -> produto.getCodigo().equals(codigo));
            listaDesejosRepository.save(listaDesejos);
        }
    }
    
}