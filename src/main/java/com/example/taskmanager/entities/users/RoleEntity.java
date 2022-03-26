package com.example.taskmanager.entities.users;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "roles")
public class RoleEntity extends AbstractPersistable<UUID> {
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "activity")
    private Boolean activity;
}
