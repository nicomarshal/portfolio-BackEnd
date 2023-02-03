package com.nicomarshal.portfolio.service;

import java.util.List;
import com.nicomarshal.portfolio.model.Experience;

public interface IExperienceService {

    public List<Experience> getExperiences();

    public void saveExperience(Experience experience);

    public void deleteExperience(Long id);

    public Experience findExperience(Long id);
}
