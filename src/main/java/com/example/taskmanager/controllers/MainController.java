package com.example.taskmanager.controllers;

import com.example.taskmanager.entities.users.UserEntity;
import com.example.taskmanager.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/authenticated")
    public String pageForAutentificatedUsers(Authentication authentication) {
        Optional<UserEntity> userEntityOpt = userService.findByUsername(authentication.getName());
        if (userEntityOpt.isEmpty()) {
            return "userNotFound";
        }
        UserEntity userEntity = userEntityOpt.get();
        return "secured part of web service:__ " + userEntity.getId() + " + " + userEntity.getUsername() + " + " + userEntity.getPassword() + "" +
                " + " + userEntity.getEmail() + " + " + userEntity.getRoleEntities().toString();
    }

    @GetMapping("/read_profile")
    public String pageForReadProfile() {
        return "read profile page";
    }

    @GetMapping("/only_for_admins")
    public String pageOnlyForAdmins() {
        return "only for admins";
    }

}
