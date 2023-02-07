package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.dto.ProjectDto;
import java.util.List;

public interface IProjectService {
    public List<ProjectDto> getProjects();
    
    public void createProject(ProjectDto projectDto);
    
    public void editProject(Long id, ProjectDto projectDto);
    
    public void deleteProject(Long id);
    
    public ProjectDto findProject(Long id);   
}
