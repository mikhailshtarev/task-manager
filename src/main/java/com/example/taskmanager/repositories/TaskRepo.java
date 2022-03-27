package com.example.taskmanager.repositories;

import com.example.taskmanager.entities.projects.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepo extends JpaRepository<TaskEntity, UUID> {
}
