package com.example.taskmanager.controllers;

import com.example.taskmanager.dto.ProjectDto;
import com.example.taskmanager.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getProjects(@RequestParam(name = "userId") UUID userId) {
        return ResponseEntity.of(projectService.getProjects(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable("id") UUID projectId) {
        return ResponseEntity.of(projectService.getProject(projectId));
    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectService.createProject(projectDto));
    }

    @PutMapping ResponseEntity<ProjectDto> updateProject(@RequestBody ProjectDto projectDto){
        return ResponseEntity.ok(projectService.updateProject(projectDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProject(@PathVariable("id") UUID projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
