package com.nicomarshal.portfolio.controller;

import com.nicomarshal.portfolio.model.Skill;
import com.nicomarshal.portfolio.service.ISkillService;
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
public class SkillController {
    
    @Autowired
    private ISkillService skillService;
    
    @GetMapping("/skill")
    @ResponseBody
    public List<Skill> getSkill() {
        return skillService.getSkills();
    }
    
    @PostMapping("/skill")
    public String createSkill(@RequestBody Skill skill){
        skillService.saveSkill(skill);
        return "El skill fue creado correctamente";
    }
    
    @PutMapping("/skill/{id}")
    public String editSkill(@PathVariable Long id,
                         @RequestParam String name,
                         @RequestParam int percentage){
        
        //Busco el role en cuestión
        Skill skill = skillService.findSkill(id);
        
        //Esto tambien pude ir en service para desacoplar
        //mejor aun el codigo en un nuevo metodo
        skill.setName(name);
        skill.setPercentage(percentage);
        
        skillService.saveSkill(skill);
        
        return "El skill fue modificado correctamente";
    }    
    
    @DeleteMapping("/skill/{id}")
    public String deleteSkill(@PathVariable Long id){
        skillService.deleteSkill(id);
        return "El skill fue eliminado correctamente";
    }
    
    @GetMapping("/skill/{id}")
    @ResponseBody
    public Skill findSkill(@PathVariable Long id) {
        return skillService.findSkill(id);
    }
}
