package com.nicomarshal.portfolio.controller;

import com.nicomarshal.portfolio.dto.SkillDto;
import com.nicomarshal.portfolio.service.ISkillService;
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
public class SkillController {
    
    @Autowired
    private ISkillService skillService;
    
    @GetMapping("/skill")
    @ResponseBody
    public List<SkillDto> getSkills() {
        return skillService.getSkills();
    }
    
    @PostMapping("/skill")
    public String createSkill(@RequestBody SkillDto skillDto){
        skillService.createSkill(skillDto);
        return "El skill fue creado correctamente";
    }
    
    @PutMapping("/skill/{id}")
    public String editSkill(@PathVariable Long id, @RequestBody SkillDto skillDto){
        
        skillService.editSkill(id, skillDto);
        return "El skill fue modificado correctamente";
    }    
    
    @DeleteMapping("/skill/{id}")
    public String deleteSkill(@PathVariable Long id){
        skillService.deleteSkill(id);
        return "El skill fue eliminado correctamente";
    }
    
    @GetMapping("/skill/{id}")
    @ResponseBody
    public SkillDto findSkill(@PathVariable Long id) {
        return skillService.findSkill(id);
    }
}
