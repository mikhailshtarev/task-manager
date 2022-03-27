package com.example.taskmanager.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TaskDto {
    private UUID id;
    private String header;
    private String description;
    private Integer priority;
    private UUID project;
    private LocalDateTime createdDateTime;
    private UUID createdUser;
}
