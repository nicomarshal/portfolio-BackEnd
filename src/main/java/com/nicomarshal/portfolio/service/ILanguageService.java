package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.model.Language;
import java.util.List;

public interface ILanguageService {
    public List<Language> getLanguages();
    
    public void saveLanguage(Language language);
    
    public void deleteLanguage(Long id);
    
    public Language findLanguage(Long id);    
}
