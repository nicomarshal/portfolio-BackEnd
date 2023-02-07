package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.dto.ExperienceTypeDto;
import java.util.List;

public interface IExperienceTypeService {
    public List<ExperienceTypeDto> getExperienceTypes();
    
    public void createExperienceType(ExperienceTypeDto experienceTypeDto);
    
    public void editExperienceType(Long id, ExperienceTypeDto experienceTypeDto);
    
    public void deleteExperienceType(Long id);
    
    public ExperienceTypeDto findExperienceType(Long id);   
}
