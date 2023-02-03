package com.nicomarshal.portfolio.service;

import java.util.List;
import com.nicomarshal.portfolio.model.Skill;

public interface ISkillService {

    public List<Skill> getSkills();
    
    public void saveSkill(Skill skill);
    
    public void deleteSkill(Long id);
    
    public Skill findSkill(Long id);
}