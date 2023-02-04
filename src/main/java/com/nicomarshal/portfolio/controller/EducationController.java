package com.nicomarshal.portfolio.controller;

import com.nicomarshal.portfolio.model.Education;
import com.nicomarshal.portfolio.service.IEducationService;
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
public class EducationController {
    
    @Autowired
    private IEducationService educationService;
    
    @GetMapping("/education")
    @ResponseBody
    public List<Education> getEducations() {
        return educationService.getEducations();
    }
    
    @PostMapping("/education")
    public String createEducation(@RequestBody Education education){
        educationService.saveEducation(education);
        return "La educación fue creada correctamente";
    }
    
    @PutMapping("/education/{id}")
    public String editEducation(@PathVariable Long id,
                                   @RequestParam String logo,
                                   @RequestParam String instName,
                                   @RequestParam String instDescription,
                                   @RequestParam String career,
                                   @RequestParam Date startDate,
                                   @RequestParam Date finishDate){
        
        //Busco la education en cuestión
        Education education = educationService.findEducation(id);
        
        //Esto tambien pude ir en service para desacoplar
        //mejor aun el codigo en un nuevo metodo
        education.setLogo(logo);
        education.setInstName(instName);
        education.setInstDescription(instDescription);
        education.setCareer(career);
        education.setStartDate(startDate);
        education.setFinishDate(finishDate);
        
        educationService.saveEducation(education);
        
        return "La educación fue modificada correctamente";
    }    
    
    @DeleteMapping("/education/{id}")
    public String deleteEducation(@PathVariable Long id){
        educationService.deleteEducation(id);
        return "La educación fue eliminada correctamente";
    }
    
    @GetMapping("/education/{id}")
    @ResponseBody
    public Education findEducation(@PathVariable Long id) {
        return educationService.findEducation(id);
    }
}
