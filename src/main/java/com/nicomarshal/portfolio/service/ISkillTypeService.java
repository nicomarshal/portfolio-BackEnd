package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.model.SkillType;
import java.util.List;

public interface ISkillTypeService {
    
    public List<SkillType> getSkillTypes();
    
    public void saveSkillType(SkillType skillType);
    
    public void deleteSkillType(Long id);
    
    public SkillType findSkillType(Long id);    
}
