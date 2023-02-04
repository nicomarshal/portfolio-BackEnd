package com.nicomarshal.portfolio.controller;

import com.nicomarshal.portfolio.model.Experience;
import com.nicomarshal.portfolio.service.IExperienceService;
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
public class ExperienceController {
    
    @Autowired
    private IExperienceService experienceService;
    
    @GetMapping("/experience")
    @ResponseBody
    public List<Experience> getExperiences() {
        return experienceService.getExperiences();
    }
    
    @PostMapping("/experience")
    public String createExperience(@RequestBody Experience experience){
        experienceService.saveExperience(experience);
        return "La experiencia fue creada correctamente";
    }
    
    @PutMapping("/experience/{id}")
    public String editExperience(@PathVariable Long id,
                         @RequestParam String logo,
                         @RequestParam String companyName,
                         @RequestParam String job,
                         @RequestParam Date startDate,
                         @RequestParam Date finishDate,
                         @RequestParam String description){
        
        //Busco la experiencia en cuestión
        Experience experience = experienceService.findExperience(id);
        
        //Esto tambien pude ir en service para desacoplar
        //mejor aun el codigo en un nuevo metodo
        experience.setLogo(logo);
        experience.setCompanyName(companyName);
        experience.setJob(job);
        experience.setStartDate(startDate);
        experience.setFinishDate(finishDate);
        experience.setDescription(description);
        
        experienceService.saveExperience(experience);
        
        return "La experiencie fue modificada correctamente";
    }    
    
    @DeleteMapping("/experience/{id}")
    public String deleteExperience(@PathVariable Long id){
        experienceService.deleteExperience(id);
        return "La experiencia fue eliminada correctamente";
    }
    
    @GetMapping("/experience/{id}")
    @ResponseBody
    public Experience findExperience(@PathVariable Long id) {
        return experienceService.findExperience(id);
    }
}

