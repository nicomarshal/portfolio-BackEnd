package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.model.EducationType;
import java.util.List;

public interface IEducationTypeService {
    public List<EducationType> getEducationTypes();
    
    public void saveEducationType(EducationType educationType);
    
    public void deleteEducationType(Long id);
    
    public EducationType findEducationType(Long id);    
}
