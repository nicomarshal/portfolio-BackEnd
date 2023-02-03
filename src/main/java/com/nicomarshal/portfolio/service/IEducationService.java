package com.nicomarshal.portfolio.service;

import java.util.List;
import com.nicomarshal.portfolio.model.Education;

public interface IEducationService {

    public List<Education> getEducations();
    
    public void saveEducation(Education education);
    
    public void deleteEducation(Long id);
    
    public Education findEducation(Long id);
}
