package com.example.taskmanager.services;

import com.example.taskmanager.entities.users.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    void save(UserEntity userEntity);

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity>  findByUserId(UUID userId);
}
