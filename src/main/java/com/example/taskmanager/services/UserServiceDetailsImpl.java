package com.example.taskmanager.services;

import com.example.taskmanager.entities.users.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceDetailsImpl implements UserDetailsService {

    private final UserService userService;


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntityOpt = userService.findByUsername(username);

        if (userEntityOpt.isEmpty()) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }
        UserEntity userEntity = userEntityOpt.get();
        Set<GrantedAuthority> grantedAuthorities = userEntity.getRoleEntities().stream()
                .map(roleEntity -> new SimpleGrantedAuthority(roleEntity.getRoleName())).collect(Collectors.toSet());

        return new User(userEntity.getUsername(), userEntity.getPassword(), grantedAuthorities);
    }
}
