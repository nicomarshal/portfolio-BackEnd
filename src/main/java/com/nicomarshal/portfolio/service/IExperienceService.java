package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.dto.ExperienceDto;
import java.util.List;

public interface IExperienceService {
    public List<ExperienceDto> getExperiences();
    
    public void createExperience(ExperienceDto experienceDto);
    
    public void editExperience(Long id, ExperienceDto experienceDto);
    
    public void deleteExperience(Long id);
    
    public ExperienceDto findExperience(Long id);  
}
