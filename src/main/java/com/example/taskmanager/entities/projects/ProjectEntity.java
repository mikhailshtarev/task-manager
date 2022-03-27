package com.example.taskmanager.entities.projects;

import com.example.taskmanager.entities.BaseEntity;
import com.example.taskmanager.entities.users.UserEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "projects")
@Entity
public class ProjectEntity extends BaseEntity<UUID> {
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "manager_id")
    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @ToString.Exclude
    private UserEntity manager;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<TaskEntity> tasks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProjectEntity that = (ProjectEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
