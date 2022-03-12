package com.example.taskmanager.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    @ManyToMany
    @JoinTable(name = "users_roles",
    joinColumns  =@JoinColumn(name = "user_id"),
            inverseJoinColumns  = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
