package com.example.taskmanager.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
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
}
