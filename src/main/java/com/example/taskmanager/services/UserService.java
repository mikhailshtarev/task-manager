package com.example.taskmanager.services;

import com.example.taskmanager.entities.UserEntity;

import java.util.Optional;

public interface UserService {
    void save(UserEntity userEntity);

    Optional<UserEntity> findByUsername(String username);
}
