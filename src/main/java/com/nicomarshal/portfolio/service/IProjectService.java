package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.model.Project;
import java.util.List;

public interface IProjectService {
    public List<Project> getProjects();
    
    public void saveProject(Project project);
    
    public void deleteProject(Long id);
    
    public Project findProject(Long id);    
}
