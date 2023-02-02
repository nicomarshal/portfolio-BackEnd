package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.model.Education;
import com.nicomarshal.portfolio.repository.IEducationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService {
    //Inyectamos dependencia
    @Autowired
    private IEducationRepository educationRepository;

    @Override
    public List<Education> getEducations() {
        List<Education> listEducations = educationRepository.findAll();
        return listEducations;
    }

    @Override
    public void saveEducation(Education education) {
        educationRepository.save(education);
    }

    @Override
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }

    @Override
    public Education findEducation(Long id) {
        //Si no encuentra la persona, devuelve null(por esso va el orElse)
        Education education = educationRepository.findById(id).orElse(null);
        return education;
    }    
}
