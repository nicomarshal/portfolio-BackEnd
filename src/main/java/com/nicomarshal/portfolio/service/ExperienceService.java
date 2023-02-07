package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.dto.ExperienceDto;
import com.nicomarshal.portfolio.model.Experience;
import com.nicomarshal.portfolio.model.ExperienceType;
import com.nicomarshal.portfolio.model.Person;
import com.nicomarshal.portfolio.repository.IExperienceRepository;
import com.nicomarshal.portfolio.repository.IExperienceTypeRepository;
import com.nicomarshal.portfolio.repository.IPersonRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperienceService {
    @Autowired
    private IExperienceRepository experienceRepository;
    @Autowired
    private IPersonRepository personRepository;
    @Autowired
    private IExperienceTypeRepository experienceTypeRepository;

    @Override
    public List<ExperienceDto> getExperiences() {
        List<Experience> listExperiences = experienceRepository.findAll();
        
        List<ExperienceDto> listExperiencesDto = new ArrayList<>();
        
        for (Experience experience : listExperiences) {
            ExperienceDto experienceDto = new ExperienceDto();
            
            //Mapeo
            experienceDto.setLogo(experience.getLogo());
            experienceDto.setCompanyName(experience.getCompanyName());
            experienceDto.setJob(experience.getJob());
            experienceDto.setStartDate(experience.getStartDate());
            experienceDto.setFinishDate(experience.getFinishDate());
            experienceDto.setDescription(experience.getDescription());            
            experienceDto.setPersonId(experience.getPerson().getId());
            experienceDto.setExperienceTypeId(experience.getExperienceType().getId());
            
            listExperiencesDto.add(experienceDto);
        }       
        return listExperiencesDto;
    }

    @Override
    public void createExperience(ExperienceDto experienceDto) {
        Long personId = experienceDto.getPersonId();     
        Person person = personRepository.findById(personId).orElse(null);
        
        Long experienceTypeId = experienceDto.getExperienceTypeId();
        ExperienceType experienceType = experienceTypeRepository.findById(experienceTypeId).orElse(null);
        
        Experience experience = new Experience();
        
        //Mapeo
        experience.setLogo(experienceDto.getLogo());
        experience.setCompanyName(experienceDto.getCompanyName());
        experience.setJob(experienceDto.getJob());
        experience.setStartDate(experienceDto.getStartDate());
        experience.setFinishDate(experienceDto.getFinishDate());
        experience.setDescription(experienceDto.getDescription());
        experience.setPerson(person);
        experience.setExperienceType(experienceType);
        
        experienceRepository.save(experience);
    }
    
    @Override
    public void editExperience(Long id, ExperienceDto experienceDto) {
        Long personId = experienceDto.getPersonId();     
        Person person = personRepository.findById(personId).orElse(null);
        
        Long experienceTypeId = experienceDto.getExperienceTypeId();
        ExperienceType experienceType = experienceTypeRepository.findById(experienceTypeId).orElse(null);
        
        Experience experience = experienceRepository.findById(id).orElse(null);
        
        //Mapeo
        experience.setLogo(experienceDto.getLogo());
        experience.setCompanyName(experienceDto.getCompanyName());
        experience.setJob(experienceDto.getJob());
        experience.setStartDate(experienceDto.getStartDate());
        experience.setFinishDate(experienceDto.getFinishDate());
        experience.setDescription(experienceDto.getDescription());
        experience.setPerson(person);
        experience.setExperienceType(experienceType);
        
        experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }

    @Override
    public ExperienceDto findExperience(Long id) {
        Experience experience = experienceRepository.findById(id).orElse(null);
        
        ExperienceDto experienceDto = new ExperienceDto();
        
        //Mapeo
        experienceDto.setLogo(experience.getLogo());
        experienceDto.setCompanyName(experience.getCompanyName());
        experienceDto.setJob(experience.getJob());
        experienceDto.setStartDate(experience.getStartDate());
        experienceDto.setFinishDate(experience.getFinishDate());
        experienceDto.setDescription(experience.getDescription());            
        experienceDto.setPersonId(experience.getPerson().getId());
        experienceDto.setExperienceTypeId(experience.getExperienceType().getId());
        
        return experienceDto;
    } 
}
