package com.github.fr3d3rico.backendrealappcase.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.fr3d3rico.backendrealappcase.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRole(String role);
}
