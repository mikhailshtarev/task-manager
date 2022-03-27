package com.example.taskmanager.mapper;

import com.example.taskmanager.dto.ProjectDto;
import com.example.taskmanager.dto.TaskDto;
import com.example.taskmanager.entities.projects.ProjectEntity;
import com.example.taskmanager.entities.projects.TaskEntity;
import com.example.taskmanager.entities.users.UserEntity;
import lombok.RequiredArgsConstructor;
import org.mapstruct.*;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
@RequiredArgsConstructor
public abstract class ProjectMapper {


    @Mapping(target = "id", source = "projectEntity.id")
    @Mapping(target = "projectName", source = "projectEntity.projectName")
    @Mapping(target = "description", source = "projectEntity.description")
    @Mapping(target = "tasks", source = "projectEntity.tasks")
    @Mapping(target = "manager", source = "projectEntity.manager.id")
    @Mapping(target = "createdDateTime", source = "projectEntity.createdDateTime")
    @Mapping(target = "createdUser", source = "projectEntity.createdUser")
    public abstract ProjectDto mapProjectEntityToDto(ProjectEntity projectEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "projectName", source = "projectDto.projectName")
    @Mapping(target = "description", source = "projectDto.description")
    @Mapping(target = "tasks", ignore = true)
    @Mapping(target = "manager", source = "userEntity")
    @Mapping(target = "createdDateTime", ignore = true)
    @Mapping(target = "createdUser", ignore = true)
    @Mapping(target = "lastUpdatedDateTime", ignore = true)
    @Mapping(target = "lastUpdatedUser", ignore = true)
    public abstract ProjectEntity mapProjectDtoToEntity(ProjectDto projectDto, UserEntity userEntity);

    @AfterMapping
    public ProjectEntity afterMappingProjectDtoToEntity(@MappingTarget ProjectEntity projectEntity, ProjectDto projectDto) {
        projectEntity.setTasks(projectDto.getTasks().stream().map(taskDto -> mapTaskDtoToEntity(taskDto, projectEntity)).collect(Collectors.toSet()));
        return projectEntity;
    }


    @Mapping(target = "id", source = "taskEntity.id")
    @Mapping(target = "header", source = "taskEntity.header")
    @Mapping(target = "description", source = "taskEntity.description")
    @Mapping(target = "priority", source = "taskEntity.priority")
    @Mapping(target = "project", source = "taskEntity.project.id")
    @Mapping(target = "createdDateTime", source = "taskEntity.createdDateTime")
    @Mapping(target = "createdUser", source = "taskEntity.createdUser")
    public abstract TaskDto mapTaskEntityToDto(TaskEntity taskEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "header", source = "taskDto.header")
    @Mapping(target = "description", source = "taskDto.description")
    @Mapping(target = "priority", source = "taskDto.priority")
    @Mapping(target = "project", source = "projectEntity")
    @Mapping(target = "createdDateTime", ignore = true)
    @Mapping(target = "createdUser", ignore = true)
    @Mapping(target = "lastUpdatedDateTime", ignore = true)
    @Mapping(target = "lastUpdatedUser", ignore = true)
    public abstract TaskEntity mapTaskDtoToEntity(TaskDto taskDto, ProjectEntity projectEntity);
}
