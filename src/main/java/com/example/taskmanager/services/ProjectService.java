package com.example.taskmanager.services;

import com.example.taskmanager.dto.ProjectDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectService {

    Optional<List<ProjectDto>> getProjects(UUID userId);

    Optional<ProjectDto> getProject(UUID projectId);

    ProjectDto createProject(ProjectDto projectDto);

    ProjectDto updateProject(ProjectDto projectDto);

    void deleteProject(UUID id);
}
