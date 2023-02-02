package com.nicomarshal.portfolio.service;

import java.util.List;
import com.nicomarshal.portfolio.model.Experience;

public interface IExperienceService {
    //Método para traer todas las personas
    public List<Experience> getExperiences();
    
    //Método para dar de alta una persona
    public void saveExperience(Experience experience);
    
    //Método para eliminar una persona
    public void deleteExperience(Long id);
    
    //Método para encontrar una persona
    public Experience findExperience(Long id);
}
