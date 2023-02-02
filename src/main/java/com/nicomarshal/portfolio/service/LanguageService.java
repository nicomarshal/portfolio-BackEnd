package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.model.Language;
import com.nicomarshal.portfolio.repository.ILanguageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class LanguageService implements ILanguageService {
    @Autowired 
    private ILanguageRepository languageRepository;

    @Override
    public List<Language> getLanguages() {
        List<Language> listLanguages = languageRepository.findAll();
        return listLanguages;
    }

    @Override
    public void saveLanguage(Language language) {
        languageRepository.save(language);
    }

    @Override
    public void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }

    @Override
    public Language findLanguage(Long id) {
        Language language = languageRepository.findById(id).orElse(null);
        return language;
    }
}
