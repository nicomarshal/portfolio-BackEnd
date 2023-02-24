package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.dto.SkillTypeDto;
import java.util.List;

public interface ISkillTypeService {
    public List<SkillTypeDto> getSkillTypes();
    
    public void createSkillType(SkillTypeDto skillTypeDto);
    
    public void editSkillType(Long id, SkillTypeDto skillTypeDto);
    
    public void deleteSkillType(Long id);
    
    public SkillTypeDto findSkillType(Long id);   
}
