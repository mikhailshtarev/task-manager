package com.example.taskmanager.services;

import com.example.taskmanager.entities.users.RoleEntity;
import com.example.taskmanager.entities.users.UserEntity;
import com.example.taskmanager.repositories.RoleRepository;
import com.example.taskmanager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String DEFAULT_ROLE = "USER";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public void save(UserEntity user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleRepository.findRoleEntityByRoleName(DEFAULT_ROLE));
        user.setRoleEntities(roles);
        userRepository.save(user);
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<UserEntity> findByUserId(UUID userId) {
        return userRepository.findById(userId);
    }
}
