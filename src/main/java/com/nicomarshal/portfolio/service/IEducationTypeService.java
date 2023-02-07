package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.dto.EducationTypeDto;
import java.util.List;

public interface IEducationTypeService {
    public List<EducationTypeDto> getEducationTypes();
    
    public void createEducationType(EducationTypeDto educationTypeDto);
    
    public void editEducationType(Long id, EducationTypeDto educationTypeDto);
    
    public void deleteEducationType(Long id);
    
    public EducationTypeDto findEducationType(Long id);   
}
