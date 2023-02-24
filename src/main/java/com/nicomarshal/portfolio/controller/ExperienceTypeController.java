package com.nicomarshal.portfolio.controller;

import com.nicomarshal.portfolio.dto.ExperienceTypeDto;
import com.nicomarshal.portfolio.service.IExperienceTypeService;
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
public class ExperienceTypeController {
    @Autowired
    private IExperienceTypeService experienceTypeService;
    
    @GetMapping("/experienceType")
    @ResponseBody
    public List<ExperienceTypeDto> getExperienceTypes() {
        return experienceTypeService.getExperienceTypes();
    }   
    
    @PostMapping("/experienceType")
    public String createExperienceType(@RequestBody ExperienceTypeDto experienceTypeDto){
        experienceTypeService.createExperienceType(experienceTypeDto);
        return "El tipo de experienca fue creada correctamente";
    }
    
    @PutMapping("/experienceType/{id}")
    public String editExperienceType(@PathVariable Long id, @RequestBody ExperienceTypeDto experienceTypeDto){
        
        experienceTypeService.editExperienceType(id, experienceTypeDto);
        return "El tipo de experienca fue modificada correctamente";
    }    
    
    @DeleteMapping("/experienceType/{id}")
    public String deleteExperienceType(@PathVariable Long id){
        experienceTypeService.deleteExperienceType(id);
        return "El tipo de experienca fue eliminada correctamente";
    }
    
    @GetMapping("/experienceType/{id}")
    @ResponseBody
    public ExperienceTypeDto findExperienceType(@PathVariable Long id) {
        return experienceTypeService.findExperienceType(id);
    }    
}

