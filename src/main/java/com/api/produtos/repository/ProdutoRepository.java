package com.api.produtos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.api.produtos.model.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> 
{

   
}
