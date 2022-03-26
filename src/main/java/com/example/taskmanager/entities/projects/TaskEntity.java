package com.example.taskmanager.entities.projects;

import com.example.taskmanager.entities.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "tasks")
public class TaskEntity extends BaseEntity<UUID> {
    @Column(name = "header")
    private String header;
    @Column(name = "description")
    private String description;
    @Column(name = "priority")
    private Integer priority;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProjectEntity project;
}
