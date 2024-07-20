package com.api.produtos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "listas_desejos")
public class ListaDesejos {

    @Id
    private String id;
    
    private String clienteId;

    @DBRef
    private Set<Produto> produtos = new HashSet<>();

    // Getters e Setters

    public ListaDesejos() {}

    public ListaDesejos(String clienteId) {
        this.clienteId = clienteId;
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

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }
}
