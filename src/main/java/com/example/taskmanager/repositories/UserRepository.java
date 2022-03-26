package com.example.taskmanager.repositories;

import com.example.taskmanager.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String userName);
}
