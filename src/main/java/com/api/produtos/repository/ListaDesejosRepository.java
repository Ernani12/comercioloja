package com.api.produtos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.api.produtos.model.ListaDesejos;

import java.util.Optional;

public interface ListaDesejosRepository extends MongoRepository<ListaDesejos, String> {
    Optional<ListaDesejos> findByClienteId(String clienteId);
}

