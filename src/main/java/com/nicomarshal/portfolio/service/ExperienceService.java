package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.model.Experience;
import com.nicomarshal.portfolio.repository.IExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperienceService {
    //Inyectamos dependencia
    @Autowired
    private IExperienceRepository experienceRepository;   

    @Override
    public List<Experience> getExperiences() {
        List<Experience> listExperiences = experienceRepository.findAll();
        return listExperiences;
    }

    @Override
    public void saveExperience(Experience experience) {
        experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }

    @Override
    public Experience findExperience(Long id) {
        //Si no encuentra la persona, devuelve null(por esso va el orElse)
        Experience experience = experienceRepository.findById(id).orElse(null);
        return experience;
    }
}
