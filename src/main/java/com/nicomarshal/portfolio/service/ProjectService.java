package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.model.Project;
import com.nicomarshal.portfolio.repository.IProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectService implements IProjectService{
    @Autowired
    private IProjectRepository projectRepository;

    @Override
    public List<Project> getProjects() {
        List<Project> listProjects = projectRepository.findAll();
        return listProjects;
    }

    @Override
    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Project findProject(Long id) {
        Project project = projectRepository.findById(id).orElse(null);
        return project;
    }
}
