package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.model.ExperienceType;
import java.util.List;

public interface IExperienceTypeService {
    public List<ExperienceType> getExperienceTypes();
    
    public void saveExperienceType(ExperienceType experienceType);
    
    public void deleteExperienceType(Long id);
    
    public ExperienceType findExperienceType(Long id);    
}
