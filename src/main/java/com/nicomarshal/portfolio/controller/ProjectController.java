package com.nicomarshal.portfolio.controller;

import com.nicomarshal.portfolio.model.Project;
import com.nicomarshal.portfolio.service.IProjectService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
    
    @Autowired
    private IProjectService projectService;
    
    @GetMapping("/project")
    @ResponseBody
    public List<Project> getProjects() {
        return projectService.getProjects();
    }
    
    @PostMapping("/project")
    public String createProject(@RequestBody Project project){
        projectService.saveProject(project);
        return "El prouecto fue creado correctamente";
    }
    
    @PutMapping("/project/{id}")
    public String editProject(@PathVariable Long id,
                         @RequestParam String name,
                         @RequestParam String description,
                         @RequestParam Date startDate,
                         @RequestParam Date finishDate,
                         @RequestParam String images,
                         @RequestParam String url){
        
        //Busco el proyecto en cuestión
        Project project = projectService.findProject(id);
        
        //Esto tambien pude ir en service para desacoplar
        //mejor aun el codigo en un nuevo metodo
        project.setName(name);
        project.setDescription(description);
        project.setStartDate(startDate);
        project.setFinishDate(finishDate);
        project.setImages(images);
        project.setUrl(url);
        
        projectService.saveProject(project);
        
        return "El proyecto fue modificado correctamente";
    }    
    
    @DeleteMapping("/project/{id}")
    public String deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
        return "El proyecto fue eliminado correctamente";
    }
    
    @GetMapping("/projecto/{id}")
    @ResponseBody
    public Project findProject(@PathVariable Long id) {
        return projectService.findProject(id);
    }
}
