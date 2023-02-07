package com.nicomarshal.portfolio.controller;

import com.nicomarshal.portfolio.dto.ExperienceDto;
import com.nicomarshal.portfolio.service.IExperienceService;
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
public class ExperienceController {
    
    @Autowired
    private IExperienceService experienceService;
    
    @GetMapping("/experience")
    @ResponseBody
    public List<ExperienceDto> getExperiences() {
        return experienceService.getExperiences();
    }
    
    @PostMapping("/experience")
    public String createExperience(@RequestBody ExperienceDto experienceDto){
        experienceService.createExperience(experienceDto);
        return "La experiencia fue creada correctamente";
    }
    
    @PutMapping("/experience/{id}")
    public String editExperience(@PathVariable Long id, @RequestBody ExperienceDto experienceDto){
        
        experienceService.editExperience(id, experienceDto);
        return "La experiencia fue modificada correctamente";
    }    
    
    @DeleteMapping("/experience/{id}")
    public String deleteExperience(@PathVariable Long id){
        experienceService.deleteExperience(id);
        return "La experiencia fue eliminada correctamente";
    }
    
    @GetMapping("/experience/{id}")
    @ResponseBody
    public ExperienceDto findExperience(@PathVariable Long id) {
        return experienceService.findExperience(id);
    }
}

