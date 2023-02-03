package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.model.SkillType;
import com.nicomarshal.portfolio.repository.ISkillTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class SkillTypeService implements ISkillTypeService{
    @Autowired
    private ISkillTypeRepository skillTypeRepository;

    @Override
    public List<SkillType> getSkillTypes() {
        List<SkillType> listSkillTypes = skillTypeRepository.findAll();
        return listSkillTypes;
    }

    @Override
    public void saveSkillType(SkillType skillType) {
        skillTypeRepository.save(skillType);
    }

    @Override
    public void deleteSkillType(Long id) {
        skillTypeRepository.deleteById(id);
    }

    @Override
    public SkillType findSkillType(Long id) {
        SkillType skillType = skillTypeRepository.findById(id).orElse(null);
        return skillType;
    }
}
