package com.api.produtos.datainicializer;


import com.api.produtos.model.Cliente;
import com.api.produtos.model.Produto;
import com.api.produtos.repository.ClienteRepository;
import com.api.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@Configuration
public class DataInitializer {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            // Verifica se a coleção já possui dados
            if (produtoRepository.count() == 0) {
                produtoRepository.saveAll(Arrays.asList( 
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
                    new Produto("TV 4K 65\" Sony Bravia", "Sony", 5999.00),
                    // Novos produtos
                    new Produto("Tablet Samsung Galaxy Tab S7", "Samsung", 2799.00),
                    new Produto("Smart TV Samsung 4K 55\"", "Samsung", 3499.00),
                    new Produto("Notebook Acer Aspire 5", "Acer", 2999.00),
                    new Produto("Fogão 4 Bocas Electrolux", "Electrolux", 1299.00),
                    new Produto("Geladeira Consul Duplex", "Consul", 1999.00),
                    new Produto("Máquina de Lavar Samsung 13kg", "Samsung", 2499.00),
                    new Produto("Micro-ondas LG 30L", "LG", 499.00),
                    new Produto("Aspirador Vertical Philco", "Philco", 349.00),
                    new Produto("Liquidificador Arno Power Max", "Arno", 149.90),
                    new Produto("Cafeteira Oster Espresso", "Oster", 499.00),
                    new Produto("Smartphone Xiaomi Mi 11", "Xiaomi", 3999.99),
                    new Produto("Home Theater LG 5.1", "LG", 999.00),
                    new Produto("Relógio Smart Samsung Galaxy Watch", "Samsung", 1299.00),
                    new Produto("Notebook Lenovo IdeaPad 3", "Lenovo", 2799.00),
                    new Produto("Ar Condicionado Portátil Philco", "Philco", 2199.00),
                    new Produto("Máquina de Lavar Consul 11kg", "Consul", 1499.00),
                    new Produto("Ventilador de Mesa Britânia", "Britânia", 129.90),
                    new Produto("Fone de Ouvido JBL Bluetooth", "JBL", 299.00),
                    new Produto("Monitor LED 24\" Dell", "Dell", 799.00),
                    new Produto("Impressora Multifuncional HP", "HP", 399.00)
                
                ));

              
            }

                // Verifica se a coleção de clientes já possui dados
            
                Cliente existingCliente = clienteRepository.findByEmail("magazine@example.com");
                if (existingCliente != null) {
                    // Cliente já existe, não faz nada
                    return;
                }
                Cliente cliente = new Cliente();
                cliente.setNome ("Luiza");
                cliente.setEmail("magazine@example.com");
                cliente.setPassword(passwordEncoder.encode("luiza"));
                clienteRepository.save(cliente);
            
        };
    }
}
   