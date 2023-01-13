package com.example.timeSheets.boot.service;


import com.example.timeSheets.boot.model.Project;
import com.example.timeSheets.boot.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public void save(Project project) {
        repository.save(project);

    }

    public Optional<Project> findProject(Long projectId) {
        return repository.findById(projectId);
    }

    public void deleteById(Long projectId) {
        repository.deleteById(projectId);
    }

    public List<Project> findByName(String searchTerm){
        return repository.findByName(searchTerm);
    }

    public Page<Project> findByNamev2(Integer pageNumber, Integer pageSize, String searchTerm){
        searchTerm = Objects.nonNull(searchTerm) ? searchTerm : "";
        return repository.findByNamev2("%"+searchTerm+"%",PageRequest.of(pageNumber, pageSize));
    }
}
