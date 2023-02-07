package com.nicomarshal.portfolio.controller;

import com.nicomarshal.portfolio.dto.EducationDto;
import com.nicomarshal.portfolio.service.IEducationService;
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
public class EducationController {
    
    @Autowired
    private IEducationService educationService;
    
    @GetMapping("/education")
    @ResponseBody
    public List<EducationDto> getEducations() {
        return educationService.getEducations();
    }
    
    @PostMapping("/education")
    public String createEducation(@RequestBody EducationDto educationDto){
        educationService.createEducation(educationDto);
        return "La educación fue creada correctamente";
    }
    
    @PutMapping("/education/{id}")
    public String editEducation(@PathVariable Long id, @RequestBody EducationDto educationDto){
        
        educationService.editEducation(id, educationDto);
        return "La educación fue modificada correctamente";
    }    
    
    @DeleteMapping("/education/{id}")
    public String deleteEducation(@PathVariable Long id){
        educationService.deleteEducation(id);
        return "La educación fue eliminada correctamente";
    }
    
    @GetMapping("/education/{id}")
    @ResponseBody
    public EducationDto findEducation(@PathVariable Long id) {
        return educationService.findEducation(id);
    }
}
