package com.nicomarshal.portfolio.controller;

import com.nicomarshal.portfolio.dto.EducationTypeDto;
import com.nicomarshal.portfolio.service.IEducationTypeService;
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
public class EducationTypeController {
    @Autowired
    private IEducationTypeService educationTypeService;
    
    @GetMapping("/educationType")
    @ResponseBody
    public List<EducationTypeDto> getEducationTypes() {
        return educationTypeService.getEducationTypes();
    }   
    
    @PostMapping("/educationType")
    public String createEducationType(@RequestBody EducationTypeDto educationTypeDto){
        educationTypeService.createEducationType(educationTypeDto);
        return "El tipo de educación fue creado correctamente";
    }
    
    @PutMapping("/educationType/{id}")
    public String editEducationType(@PathVariable Long id, @RequestBody EducationTypeDto educationTypeDto){
        
        educationTypeService.editEducationType(id, educationTypeDto);
        return "El tipo de educación fue modificado correctamente";
    }    
    
    @DeleteMapping("/educationType/{id}")
    public String deleteEducationType(@PathVariable Long id){
        educationTypeService.deleteEducationType(id);
        return "El tipo de educación fue eliminado correctamente";
    }
    
    @GetMapping("/educationType/{id}")
    @ResponseBody
    public EducationTypeDto findEducationType(@PathVariable Long id) {
        return educationTypeService.findEducationType(id);
    }    
}
