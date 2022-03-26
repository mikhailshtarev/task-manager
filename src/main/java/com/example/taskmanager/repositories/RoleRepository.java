package com.example.taskmanager.repositories;

import com.example.taskmanager.entities.users.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    @Query("select r from RoleEntity r where r.roleName=:roleName")
    RoleEntity findRoleEntityByRoleName(String roleName);
}
