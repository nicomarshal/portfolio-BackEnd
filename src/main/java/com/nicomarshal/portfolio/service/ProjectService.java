package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.dto.ProjectDto;
import com.nicomarshal.portfolio.model.Person;
import com.nicomarshal.portfolio.model.Project;
import com.nicomarshal.portfolio.repository.IPersonRepository;
import com.nicomarshal.portfolio.repository.IProjectRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService{
    @Autowired
    private IProjectRepository projectRepository;
    @Autowired
    private IPersonRepository personRepository;

    @Override
    public List<ProjectDto> getProjects() {
        List<Project> listProjects = projectRepository.findAll();
        
        List<ProjectDto> listProjectsDto = new ArrayList<>();
        
        for (Project project : listProjects) {
            ProjectDto projectDto = new ProjectDto();
            
            //Mapeo
            projectDto.setName(project.getName());
            projectDto.setDescription(project.getDescription());
            projectDto.setStartDate(project.getStartDate());
            projectDto.setFinishDate(project.getFinishDate());
            projectDto.setImages(project.getImages());
            projectDto.setUrl(project.getUrl());                        
            projectDto.setPersonId(project.getPerson().getId());
            
            listProjectsDto.add(projectDto);
        }       
        return listProjectsDto;
    }

    @Override
    public void createProject(ProjectDto projectDto) {
        Long personId = projectDto.getPersonId();     
        Person person = personRepository.findById(personId).orElse(null);
        
        Project project = new Project();
        
        //Mapeo
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        project.setStartDate(projectDto.getStartDate());
        project.setFinishDate(projectDto.getFinishDate());
        project.setImages(projectDto.getImages());
        project.setUrl(projectDto.getUrl());                        
        project.setPerson(person);
        
        projectRepository.save(project);
    }
    
    @Override
    public void editProject(Long id, ProjectDto projectDto) {
        Long personId = projectDto.getPersonId();     
        Person person = personRepository.findById(personId).orElse(null);
        
        Project project = projectRepository.findById(id).orElse(null);
        
        //Mapeo
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        project.setStartDate(projectDto.getStartDate());
        project.setFinishDate(projectDto.getFinishDate());
        project.setImages(projectDto.getImages());
        project.setUrl(projectDto.getUrl());                        
        project.setPerson(person);
        
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectDto findProject(Long id) {
        Project project = projectRepository.findById(id).orElse(null);
        
        ProjectDto projectDto = new ProjectDto();
        
        //Mapeo
        projectDto.setName(project.getName());
        projectDto.setDescription(project.getDescription());
        projectDto.setStartDate(project.getStartDate());
        projectDto.setFinishDate(project.getFinishDate());
        projectDto.setImages(project.getImages());
        projectDto.setUrl(project.getUrl());                        
        projectDto.setPersonId(project.getPerson().getId());
        
        return projectDto;
    }
}
