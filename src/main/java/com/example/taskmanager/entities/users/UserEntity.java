package com.example.taskmanager.entities.users;

import com.example.taskmanager.entities.BaseEntity;
import com.example.taskmanager.entities.projects.ProjectEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity<UUID> {
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roleEntities;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ProjectEntity> projects = new HashSet<>();

    public void addProject(ProjectEntity projectEntity) {
        projects.add(projectEntity);
        projectEntity.setManager(this);
    }

    public void removeProject(ProjectEntity projectEntity) {
        projects.remove(projectEntity);
        projectEntity.setManager(null);
    }
}
