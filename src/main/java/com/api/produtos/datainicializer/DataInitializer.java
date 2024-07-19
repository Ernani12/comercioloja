package com.api.produtos.datainicializer;


import com.api.produtos.model.Produto;
import com.api.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataInitializer {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            // Verifica se a coleção já possui dados
            if (produtoRepository.count() == 0) {
                List<Produto> produtos = Arrays.asList(
                    new Produto("Smartphone Samsung Galaxy S21", "Samsung", 3999.99),
                    new Produto("TV LED 50\" LG UHD 4K", "LG", 2999.00),
                    new Produto("Notebook Dell Inspiron 15", "Dell", 3499.00),
                    new Produto("Geladeira Brastemp Frost Free", "Brastemp", 2399.99),
                    new Produto("Ar Condicionado Split 12000 BTUs", "Samsung", 1799.00),
                    new Produto("Lavadora de Roupas Electrolux 11kg", "Electrolux", 1599.00),
                    new Produto("Micro-ondas Panasonic 20L", "Panasonic", 399.90),
                    new Produto("Ferro de Passar Arno Dual Clean", "Arno", 149.90),
                    new Produto("Cafeteira Nespresso Essenza Mini", "Nespresso", 699.00),
                    new Produto("Ventilador de Torre Mondial", "Mondial", 249.90),
                    new Produto("Console Playstation 5", "Sony", 4999.99),
                    new Produto("Soundbar JBL 2.1", "JBL", 899.00),
                    new Produto("Smartwatch Apple Watch Series 7", "Apple", 3699.00),
                    new Produto("Máquina de Lavar Louças Brastemp", "Brastemp", 2799.00),
                    new Produto("Aspirador de Pó Philips Walita", "Philips", 499.00),
                    new Produto("Fritadeira Elétrica Cadence", "Cadence", 299.00),
                    new Produto("Celular Motorola Moto G Power", "Motorola", 2499.00),
                    new Produto("Teclado Mecânico Logitech G Pro", "Logitech", 499.00),
                    new Produto("Cadeira Gamer DXRacer", "DXRacer", 1199.00),
                    new Produto("TV 4K 65\" Sony Bravia", "Sony", 5999.00)
                );      

                produtoRepository.saveAll(produtos);
            }
        };
    }
}
   