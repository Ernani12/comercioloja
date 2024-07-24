package com.api.produtos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.api.produtos.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

    Cliente findByEmail(String email);
}
