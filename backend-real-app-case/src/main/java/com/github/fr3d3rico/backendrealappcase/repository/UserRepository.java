package com.github.fr3d3rico.backendrealappcase.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.fr3d3rico.backendrealappcase.model.User;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);
}
