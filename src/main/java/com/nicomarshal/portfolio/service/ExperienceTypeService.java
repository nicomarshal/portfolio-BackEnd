package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.dto.ExperienceTypeDto;
import com.nicomarshal.portfolio.model.ExperienceType;
import com.nicomarshal.portfolio.repository.IExperienceTypeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceTypeService implements IExperienceTypeService {
    @Autowired
    private IExperienceTypeRepository experienceTypeRepository;

    @Override
    public List<ExperienceTypeDto> getExperienceTypes() {
        List<ExperienceType> listExperienceTypes = experienceTypeRepository.findAll();
        
        List<ExperienceTypeDto> listExperienceTypesDto = new ArrayList<>();
        
        for (ExperienceType experienceType : listExperienceTypes) {
            ExperienceTypeDto experienceTypeDto = new ExperienceTypeDto();
            
            //Mapeo
            experienceTypeDto.setType(experienceType.getType());
            experienceTypeDto.setDescription(experienceType.getDescription());
            
            listExperienceTypesDto.add(experienceTypeDto);
        }       
        return listExperienceTypesDto;
    }

    @Override
    public void createExperienceType(ExperienceTypeDto experienceTypeDto) {
        ExperienceType experienceType = new ExperienceType();
        
        //Mapeo
        experienceType.setType(experienceTypeDto.getType());
        experienceType.setDescription(experienceTypeDto.getDescription());
        
        experienceTypeRepository.save(experienceType);
    }
    
    @Override
    public void editExperienceType(Long id, ExperienceTypeDto experienceTypeDto) {
        ExperienceType experienceType = experienceTypeRepository.findById(id).orElse(null);
        
        //Mapeo
        experienceType.setType(experienceTypeDto.getType());
        experienceType.setDescription(experienceTypeDto.getDescription());
        
        experienceTypeRepository.save(experienceType);
    }

    @Override
    public void deleteExperienceType(Long id) {
        experienceTypeRepository.deleteById(id);
    }

    @Override
    public ExperienceTypeDto findExperienceType(Long id) {
        ExperienceType experienceType = experienceTypeRepository.findById(id).orElse(null);
        
        ExperienceTypeDto experienceTypeDto = new ExperienceTypeDto();
        
        //Mapeo
        experienceTypeDto.setType(experienceType.getType());
        experienceTypeDto.setDescription(experienceType.getDescription());
        
        return experienceTypeDto;
    }
}
