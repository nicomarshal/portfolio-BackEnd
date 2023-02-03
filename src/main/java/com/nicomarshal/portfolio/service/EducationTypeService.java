package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.model.EducationType;
import com.nicomarshal.portfolio.repository.IEducationTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationTypeService implements IEducationTypeService{
    @Autowired
    private IEducationTypeRepository educationTypeRepository;

    @Override
    public List<EducationType> getEducationTypes() {
        List<EducationType> listEducationTypes = educationTypeRepository.findAll();
        return listEducationTypes;
    }

    @Override
    public void saveEducationType(EducationType educationType) {
        educationTypeRepository.save(educationType);
    }

    @Override
    public void deleteEducationType(Long id) {
        educationTypeRepository.deleteById(id);
    }

    @Override
    public EducationType findEducationType(Long id) {
        EducationType educationType = educationTypeRepository.findById(id).orElse(null);
        return educationType;
    }    
}
