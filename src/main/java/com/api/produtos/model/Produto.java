

package com.api.produtos.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import org.springframework.data.annotation.Id;


//lombok generate setters and getters abstract
@Getter
@Setter
@Document(collection = "produtos")
public class Produto {

    @Id
    private String codigo;
    private String nome;
    private String marca;
    private Double Preco;
 
      // Construtor sem parâmetros
    public Produto() {
        this.codigo = generateCustomId();
    }
    
    public Produto(String codigo, String nome, String marca, Double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.marca = marca; 
        this.Preco = preco;
    }
    
   
    public Produto(String nome, String marca, Double preco) {
        this.nome = nome;
        this.marca = marca;
        Preco = preco;
    }

    private String generateCustomId() {
        UUID uuid = UUID.randomUUID();
        // Transformando UUID em string e pegando os primeiros 8 caracteres para maior legibilidade
        return uuid.toString().substring(0, 2);
    }
 
    
}