package com.example.taskmanager.entities.projects;

import com.example.taskmanager.entities.BaseEntity;
import com.example.taskmanager.entities.users.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@Table(name = "projects")
@Entity
public class ProjectEntity extends BaseEntity<UUID> {
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TaskEntity> tasks;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity manager;
}
