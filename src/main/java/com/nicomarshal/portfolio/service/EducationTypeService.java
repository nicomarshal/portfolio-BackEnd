package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.dto.EducationTypeDto;
import com.nicomarshal.portfolio.model.EducationType;
import com.nicomarshal.portfolio.repository.IEducationTypeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationTypeService implements IEducationTypeService{
    @Autowired
    private IEducationTypeRepository educationTypeRepository;

    @Override
    public List<EducationTypeDto> getEducationTypes() {
        List<EducationType> listEducationTypes = educationTypeRepository.findAll();
        
        List<EducationTypeDto> listEducationTypesDto = new ArrayList<>();
        
        for (EducationType educationType : listEducationTypes) {
            EducationTypeDto educationTypeDto = new EducationTypeDto();
            
            //Mapeo
            educationTypeDto.setType(educationType.getType());
            educationTypeDto.setDescription(educationType.getDescription());
            
            listEducationTypesDto.add(educationTypeDto);
        }       
        return listEducationTypesDto;
    }

    @Override
    public void createEducationType(EducationTypeDto educationTypeDto) {
        EducationType educationType = new EducationType();
        
        //Mapeo
        educationType.setType(educationTypeDto.getType());
        educationType.setDescription(educationTypeDto.getDescription());
        
        educationTypeRepository.save(educationType);
    }
    
    @Override
    public void editEducationType(Long id, EducationTypeDto educationTypeDto) {
        EducationType educationType = educationTypeRepository.findById(id).orElse(null);
        
        //Mapeo
        educationType.setType(educationTypeDto.getType());
        educationType.setDescription(educationTypeDto.getDescription());
        
        educationTypeRepository.save(educationType);
    }

    @Override
    public void deleteEducationType(Long id) {
        educationTypeRepository.deleteById(id);
    }

    @Override
    public EducationTypeDto findEducationType(Long id) {
        EducationType educationType = educationTypeRepository.findById(id).orElse(null);
        
        EducationTypeDto educationTypeDto = new EducationTypeDto();
        
        //Mapeo
        educationTypeDto.setType(educationType.getType());
        educationTypeDto.setDescription(educationType.getDescription());
        
        return educationTypeDto;
    }   
}
