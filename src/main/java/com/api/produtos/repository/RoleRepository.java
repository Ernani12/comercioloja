package com.api.produtos.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.api.produtos.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByName(String name);
}
