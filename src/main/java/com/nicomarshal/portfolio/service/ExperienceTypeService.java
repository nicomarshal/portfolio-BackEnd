package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.model.ExperienceType;
import com.nicomarshal.portfolio.repository.IExperienceTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceTypeService implements IExperienceTypeService {
    @Autowired
    private IExperienceTypeRepository experienceTypeRepository;

    @Override
    public List<ExperienceType> getExperienceTypes() {
        List<ExperienceType> listExperienceTypes = experienceTypeRepository.findAll();
        return listExperienceTypes;
    }

    @Override
    public void saveExperienceType(ExperienceType experienceType) {
        experienceTypeRepository.save(experienceType);
    }

    @Override
    public void deleteExperienceType(Long id) {
        experienceTypeRepository.deleteById(id);
    }

    @Override
    public ExperienceType findExperienceType(Long id) {
        ExperienceType experienceType = experienceTypeRepository.findById(id).orElse(null);
        return experienceType;
    }  
}
