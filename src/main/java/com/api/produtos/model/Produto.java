

package com.api.produtos.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


//lombok generate setters and getters abstract
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "produtos")
public class Produto {

    @Id
    private String codigo;
    private String nome;
    private String marca;
    private Double Preco;

    // Construtor sem parâmetros
    public Produto() {
    } 

    public Produto(String nome, String marca, Double preco) {
        this.nome = nome;
        this.marca = marca;
        this.Preco = preco;
    }
    
}