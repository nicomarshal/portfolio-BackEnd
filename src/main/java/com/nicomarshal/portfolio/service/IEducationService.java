package com.nicomarshal.portfolio.service;

import java.util.List;
import com.nicomarshal.portfolio.dto.EducationDto;

public interface IEducationService {
    public List<EducationDto> getEducations();
    
    public void createEducation(EducationDto educationDto);
    
    public void editEducation(Long id, EducationDto educationDto);
    
    public void deleteEducation(Long id);
    
    public EducationDto findEducation(Long id);
}
