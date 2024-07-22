package com.api.produtos.datainicializer;


import com.api.produtos.model.Produto;
import com.api.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.css.Counter;

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
                produtoRepository.saveAll(Arrays.asList( 
                    new Produto("1","Smartphone Samsung Galaxy S21", "Samsung", 3999.99),
                    new Produto("2","TV LED 50\" LG UHD 4K", "LG", 2999.00),
                    new Produto("3","Notebook Dell Inspiron 15", "Dell", 3499.00),
                    new Produto("4","Geladeira Brastemp Frost Free", "Brastemp", 2399.99),
                    new Produto("5","Ar Condicionado Split 12000 BTUs", "Samsung", 1799.00),
                    new Produto("6","Lavadora de Roupas Electrolux 11kg", "Electrolux", 1599.00),
                    new Produto("7","Micro-ondas Panasonic 20L", "Panasonic", 399.90),
                    new Produto("8","Ferro de Passar Arno Dual Clean", "Arno", 149.90),
                    new Produto("9","Cafeteira Nespresso Essenza Mini", "Nespresso", 699.00),
                    new Produto("10","Ventilador de Torre Mondial", "Mondial", 249.90),
                    new Produto("11","Console Playstation 5", "Sony", 4999.99),
                    new Produto("12","Soundbar JBL 2.1", "JBL", 899.00),
                    new Produto("13","Smartwatch Apple Watch Series 7", "Apple", 3699.00),
                    new Produto("14","Máquina de Lavar Louças Brastemp", "Brastemp", 2799.00),
                    new Produto("15","Aspirador de Pó Philips Walita", "Philips", 499.00),
                    new Produto("16","Fritadeira Elétrica Cadence", "Cadence", 299.00),
                    new Produto("17","Celular Motorola Moto G Power", "Motorola", 2499.00),
                    new Produto("18","Teclado Mecânico Logitech G Pro", "Logitech", 499.00),
                    new Produto("19","Cadeira Gamer DXRacer", "DXRacer", 1199.00),
                    new Produto("20","TV 4K 65\" Sony Bravia", "Sony", 5999.00)
                ));

              
            }
        };
    }
}
   