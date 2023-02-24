package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.dto.SkillDto;
import com.nicomarshal.portfolio.model.Person;
import com.nicomarshal.portfolio.model.Skill;
import com.nicomarshal.portfolio.model.SkillType;
import com.nicomarshal.portfolio.repository.IPersonRepository;
import com.nicomarshal.portfolio.repository.ISkillRepository;
import com.nicomarshal.portfolio.repository.ISkillTypeRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService {
    @Autowired
    private ISkillRepository skillRepository;
    @Autowired
    private IPersonRepository personRepository;
    @Autowired
    private ISkillTypeRepository skillTypeRepository;

    @Override
    public List<SkillDto> getSkills() {
        List<Skill> listSkills = skillRepository.findAll();
        
        List<SkillDto> listSkillsDto = new ArrayList<>();
        
        for (Skill skill : listSkills) {
            SkillDto skillDto = new SkillDto();
            
            //Mapeo
            skillDto.setName(skill.getName());
            skillDto.setPercentage(skill.getPercentage());            
            skillDto.setPersonId(skill.getPerson().getId());
            skillDto.setSkillTypeId(skill.getSkillType().getId());
            
            listSkillsDto.add(skillDto);
        }       
        return listSkillsDto;
    }

    @Override
    public void createSkill(SkillDto skillDto) {
        Long personId = skillDto.getPersonId();     
        Person person = personRepository.findById(personId).orElse(null);
        
        Long skillTypeId = skillDto.getSkillTypeId();
        SkillType skillType = skillTypeRepository.findById(skillTypeId).orElse(null);
        
        Skill skill = new Skill();
        
        //Mapeo
        skill.setName(skillDto.getName());
        skill.setPercentage(skillDto.getPercentage());
        skill.setPerson(person);
        skill.setSkillType(skillType);
        
        skillRepository.save(skill);
    }
    
    @Override
    public void editSkill(Long id, SkillDto skillDto) {
        Long personId = skillDto.getPersonId();     
        Person person = personRepository.findById(personId).orElse(null);
        
        Long skillTypeId = skillDto.getSkillTypeId();
        SkillType skillType = skillTypeRepository.findById(skillTypeId).orElse(null);
        
        Skill skill = skillRepository.findById(id).orElse(null);
        
        //Mapeo
        skill.setName(skillDto.getName());
        skill.setPercentage(skillDto.getPercentage());
        skill.setPerson(person);
        skill.setSkillType(skillType);
        
        skillRepository.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public SkillDto findSkill(Long id) {
        Skill skill = skillRepository.findById(id).orElse(null);
        
        SkillDto skillDto = new SkillDto();
        
        //Mapeo
        skillDto.setName(skill.getName());
        skillDto.setPercentage(skill.getPercentage());            
        skillDto.setPersonId(skill.getPerson().getId());
        skillDto.setSkillTypeId(skill.getSkillType().getId());
        
        return skillDto;
    } 
}
