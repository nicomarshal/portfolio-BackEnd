package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.dto.SkillTypeDto;
import com.nicomarshal.portfolio.model.SkillType;
import com.nicomarshal.portfolio.repository.ISkillTypeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillTypeService implements ISkillTypeService{
    @Autowired
    private ISkillTypeRepository skillTypeRepository;

    @Override
    public List<SkillTypeDto> getSkillTypes() {
        List<SkillType> listSkillTypes = skillTypeRepository.findAll();
        
        List<SkillTypeDto> listSkillTypesDto = new ArrayList<>();
        
        for (SkillType skillType : listSkillTypes) {
            SkillTypeDto skillTypeDto = new SkillTypeDto();
            
            //Mapeo
            skillTypeDto.setType(skillType.getType());
            skillTypeDto.setDescription(skillType.getDescription());
            
            listSkillTypesDto.add(skillTypeDto);
        }       
        return listSkillTypesDto;
    }

    @Override
    public void createSkillType(SkillTypeDto skillTypeDto) {
        SkillType skillType = new SkillType();
        
        //Mapeo
        skillType.setType(skillTypeDto.getType());
        skillType.setDescription(skillTypeDto.getDescription());
        
        skillTypeRepository.save(skillType);
    }
    
    @Override
    public void editSkillType(Long id, SkillTypeDto skillTypeDto) {
        SkillType skillType = skillTypeRepository.findById(id).orElse(null);
        
        //Mapeo
        skillType.setType(skillTypeDto.getType());
        skillType.setDescription(skillTypeDto.getDescription());
        
        skillTypeRepository.save(skillType);
    }

    @Override
    public void deleteSkillType(Long id) {
        skillTypeRepository.deleteById(id);
    }

    @Override
    public SkillTypeDto findSkillType(Long id) {
        SkillType skillType = skillTypeRepository.findById(id).orElse(null);
        
        SkillTypeDto skillTypeDto = new SkillTypeDto();
        
        //Mapeo
        skillTypeDto.setType(skillType.getType());
        skillTypeDto.setDescription(skillType.getDescription());
        
        return skillTypeDto;
    }   
}
