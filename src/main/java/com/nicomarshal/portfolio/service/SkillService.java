package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.model.Skill;
import com.nicomarshal.portfolio.repository.ISkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class SkillService implements ISkillService {
    //Inyectamos dependencia
    @Autowired
    private ISkillRepository skillRepository;

    @Override
    public List<Skill> getSkills() {
        List<Skill> listSkills = skillRepository.findAll();
        return listSkills;
    }

    @Override
    public void saveSkill(Skill skill) {
        skillRepository.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public Skill findSkill(Long id) {
        Skill skill = skillRepository.findById(id).orElse(null);
        return skill;
    }
}
