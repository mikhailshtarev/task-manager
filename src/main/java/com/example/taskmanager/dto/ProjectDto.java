package com.example.taskmanager.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
public class ProjectDto {
    private UUID id;
    private String projectName;
    private String description;
    private Set<TaskDto> tasks;
    private UUID manager;
    private LocalDateTime createdDateTime;
    private UUID createdUser;
}

