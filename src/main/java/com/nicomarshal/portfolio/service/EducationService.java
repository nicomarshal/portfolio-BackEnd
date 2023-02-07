package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.dto.EducationDto;
import com.nicomarshal.portfolio.model.Education;
import com.nicomarshal.portfolio.model.Person;
import com.nicomarshal.portfolio.model.EducationType;
import com.nicomarshal.portfolio.repository.IEducationRepository;
import com.nicomarshal.portfolio.repository.IEducationTypeRepository;
import com.nicomarshal.portfolio.repository.IPersonRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService {
    @Autowired
    private IEducationRepository educationRepository;
    @Autowired
    private IPersonRepository personRepository;
    @Autowired
    private IEducationTypeRepository educationTypeRepository;

    @Override
    public List<EducationDto> getEducations() {
        List<Education> listEducations = educationRepository.findAll();
        
        List<EducationDto> listEducationsDto = new ArrayList<>();
        
        for (Education education : listEducations) {
            EducationDto educationDto = new EducationDto();
            
            //Mapeo
            educationDto.setLogo(education.getLogo());
            educationDto.setInstName(education.getInstName());
            educationDto.setInstDescription(education.getInstDescription());
            educationDto.setCareer(education.getCareer());
            educationDto.setStartDate(education.getStartDate());
            educationDto.setFinishDate(education.getFinishDate());
            educationDto.setPersonId(education.getPerson().getId());
            educationDto.setEducationTypeId(education.getEducationType().getId());
            
            listEducationsDto.add(educationDto);
        }       
        return listEducationsDto;
    }

    @Override
    public void createEducation(EducationDto educationDto) {
        Long personId = educationDto.getPersonId();     
        Person person = personRepository.findById(personId).orElse(null);
        
        Long educationTypeId = educationDto.getEducationTypeId();
        EducationType educationType = educationTypeRepository.findById(educationTypeId).orElse(null);
        
        Education education = new Education();
        
        //Mapeo
        education.setLogo(educationDto.getLogo());
        education.setInstName(educationDto.getInstName());
        education.setInstDescription(educationDto.getInstDescription());
        education.setCareer(educationDto.getCareer());
        education.setStartDate(educationDto.getStartDate());
        education.setFinishDate(educationDto.getFinishDate());
        education.setPerson(person);
        education.setEducationType(educationType);
        
        educationRepository.save(education);
    }
    
    @Override
    public void editEducation(Long id, EducationDto educationDto) {
        Long personId = educationDto.getPersonId();     
        Person person = personRepository.findById(personId).orElse(null);
        
        Long educationTypeId = educationDto.getEducationTypeId();
        EducationType educationType = educationTypeRepository.findById(educationTypeId).orElse(null);
        
        Education education = educationRepository.findById(id).orElse(null);
        
        //Mapeo
        education.setLogo(educationDto.getLogo());
        education.setInstName(educationDto.getInstName());
        education.setInstDescription(educationDto.getInstDescription());
        education.setCareer(educationDto.getCareer());
        education.setStartDate(educationDto.getStartDate());
        education.setFinishDate(educationDto.getFinishDate());
        education.setPerson(person);
        education.setEducationType(educationType);
        
        educationRepository.save(education);
    }

    @Override
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }

    @Override
    public EducationDto findEducation(Long id) {
        Education education = educationRepository.findById(id).orElse(null);
        
        EducationDto educationDto = new EducationDto();
        
        //Mapeo
        educationDto.setLogo(education.getLogo());
        educationDto.setInstName(education.getInstName());
        educationDto.setInstDescription(education.getInstDescription());
        educationDto.setCareer(education.getCareer());
        educationDto.setStartDate(education.getStartDate());
        educationDto.setFinishDate(education.getFinishDate());
        educationDto.setPersonId(education.getPerson().getId());
        educationDto.setEducationTypeId(education.getEducationType().getId());
        
        return educationDto;
    }   
}
