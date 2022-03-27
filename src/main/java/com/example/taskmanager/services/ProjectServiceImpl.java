package com.example.taskmanager.services;

import com.example.taskmanager.dto.ProjectDto;
import com.example.taskmanager.entities.projects.ProjectEntity;
import com.example.taskmanager.entities.users.UserEntity;
import com.example.taskmanager.mapper.ProjectMapper;
import com.example.taskmanager.repositories.ProjectRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepo projectRepo;
    private final ProjectMapper projectMapper;
    private final UserService userService;

    public Optional<List<ProjectDto>> getProjects(UUID userId) {
        Optional<List<ProjectEntity>> projectEntitiesOpt = projectRepo.findAllByManager(userId);
        if (projectEntitiesOpt.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(projectEntitiesOpt.get().stream().map(projectMapper::mapProjectEntityToDto).collect(Collectors.toList()));
    }

    @Override
    public Optional<ProjectDto> getProject(UUID projectId) {
        return projectRepo.findById(projectId).map(projectMapper::mapProjectEntityToDto);
    }

    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        Optional<UserEntity> userOpt = userService.findByUserId(projectDto.getManager());
        if (userOpt.isEmpty()) {
            //TODO создать контроллер для Exceptions и переделать
            throw new RuntimeException();
        }
        ProjectEntity projectEntity = projectMapper.mapProjectDtoToEntity(projectDto, userOpt.get());
        return projectMapper.mapProjectEntityToDto(projectRepo.save(projectEntity));
    }

    @Override
    public ProjectDto updateProject(ProjectDto projectDto) {
        return null;
    }

    @Override
    public void deleteProject(UUID id) {
        projectRepo.deleteById(id);
    }
}
