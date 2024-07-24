package com.api.produtos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "lista_desejos")
public class ListaDesejos {

    @Id
    private String id;
    
    private String clienteId;

    private static final int MAX_SIZE = 20;


    @DBRef
    private List<Produto> produtos;

    public ListaDesejos() {
        this.produtos = new ArrayList<>();
    }

    // Getters e Setters
    public ListaDesejos(String clienteId) {
        this.clienteId = clienteId;
    }

    public ListaDesejos(String id, List<Produto> produtos) {
        this.id = id;
        this.produtos = produtos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }
}
