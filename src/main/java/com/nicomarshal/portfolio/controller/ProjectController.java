package com.nicomarshal.portfolio.controller;

import com.nicomarshal.portfolio.dto.ProjectDto;
import com.nicomarshal.portfolio.service.IProjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
    
    @Autowired
    private IProjectService projectService;
    
    @GetMapping("/project")
    @ResponseBody
    public List<ProjectDto> getProjects() {
        return projectService.getProjects();
    }
    
    @PostMapping("/project")
    public String createProject(@RequestBody ProjectDto projectDto){
        projectService.createProject(projectDto);
        return "El proyecto fue creado correctamente";
    }
    
    @PutMapping("/project/{id}")
    public String editProject(@PathVariable Long id, @RequestBody ProjectDto projectDto){
        
        projectService.editProject(id, projectDto);
        return "El proyecto fue modificado correctamente";
    }    
    
    @DeleteMapping("/project/{id}")
    public String deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
        return "El proyecto fue eliminado correctamente";
    }
    
    @GetMapping("/project/{id}")
    @ResponseBody
    public ProjectDto findProject(@PathVariable Long id) {
        return projectService.findProject(id);
    }
}
