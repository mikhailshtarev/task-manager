package com.example.taskmanager.controllers;

import com.example.taskmanager.entities.User;
import com.example.taskmanager.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


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
        User user = userService.findByUsername(authentication.getName());
        return "secured part of web service:__ " + user.getId()+" + "+user.getUsername()+" + "+user.getPassword()+"" +
                " + "+user.getEmail()+" + "+user.getRoles().toString();
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
