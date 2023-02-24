package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.dto.SkillDto;
import java.util.List;

public interface ISkillService {
    public List<SkillDto> getSkills();
    
    public void createSkill(SkillDto experienceDto);
    
    public void editSkill(Long id, SkillDto experienceDto);
    
    public void deleteSkill(Long id);
    
    public SkillDto findSkill(Long id);
}