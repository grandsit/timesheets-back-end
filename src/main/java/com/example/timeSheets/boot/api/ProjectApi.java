package com.example.timeSheets.boot.api;

import com.example.timeSheets.boot.model.Project;
import com.example.timeSheets.boot.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("project")
public class ProjectApi {

    @Autowired
    private ProjectService service;

    @PostMapping
    public String save(@RequestBody Project project) {
        service.save(project);
        return "Project saved with success";
    }

    @GetMapping
    public ResponseEntity findByName(@RequestParam String searchTerm) {
        return ResponseEntity.ok(service.findByName(searchTerm));
    }

    @GetMapping("/v2")
    public Page<Project> findByNamev2(@RequestParam String searchTerm,
                                      @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return service.findByNamev2(pageNumber, pageSize, searchTerm);
    }

    @GetMapping("/{projectId}")
    public Optional<Project> findProject(@PathVariable Long projectId) {
        return service.findProject(projectId);
    }

    @PutMapping
    public String update(@RequestBody Project project) {
        service.save(project);
        return "Project with success";
    }

    @DeleteMapping("/{projectId}")
    public String deleteProject(@PathVariable Long projectId) {
        service.deleteById(projectId);
        return "Project " + projectId + " Was deleted";
    }
}
