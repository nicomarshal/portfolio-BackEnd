package com.nicomarshal.portfolio.controller;

import com.nicomarshal.portfolio.dto.SkillTypeDto;
import com.nicomarshal.portfolio.service.ISkillTypeService;
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
public class SkillTypeController {
    @Autowired
    private ISkillTypeService skillTypeService;
    
    @GetMapping("/skillType")
    @ResponseBody
    public List<SkillTypeDto> getSkillTypes() {
        return skillTypeService.getSkillTypes();
    }   
    
    @PostMapping("/skillType")
    public String createSkillType(@RequestBody SkillTypeDto skillTypeDto){
        skillTypeService.createSkillType(skillTypeDto);
        return "El tipo de skill fue creado correctamente";
    }
    
    @PutMapping("/skillType/{id}")
    public String editSkillType(@PathVariable Long id, @RequestBody SkillTypeDto skillTypeDto){
        
        skillTypeService.editSkillType(id, skillTypeDto);
        return "El tipo de skill fue modificado correctamente";
    }    
    
    @DeleteMapping("/skillType/{id}")
    public String deleteSkillType(@PathVariable Long id){
        skillTypeService.deleteSkillType(id);
        return "El tipo de skill fue eliminado correctamente";
    }
    
    @GetMapping("/skillType/{id}")
    @ResponseBody
    public SkillTypeDto findSkillType(@PathVariable Long id) {
        return skillTypeService.findSkillType(id);
    }    
}
