package com.example.taskmanager.repositories;

import com.example.taskmanager.entities.projects.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectRepo extends JpaRepository<ProjectEntity, UUID> {
    @Query("select u from ProjectEntity u where u.manager.id=:managerId")
    Optional<List<ProjectEntity>> findAllByManager(UUID managerId);

}
