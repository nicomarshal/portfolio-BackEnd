package com.nicomarshal.portfolio.controller;

import com.nicomarshal.portfolio.model.Language;
import com.nicomarshal.portfolio.service.ILanguageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {
    
    @Autowired
    private ILanguageService languageService;
    
    @GetMapping("/language")
    @ResponseBody
    public List<Language> getLanguages() {
        return languageService.getLanguages();
    }
    
    @PostMapping("/language")
    public String createLanguage(@RequestBody Language language){
        languageService.saveLanguage(language);
        return "El lenguaje fue creado correctamente";
    }
    
    @PutMapping("/language/{id}")
    public String editLanguage(@PathVariable Long id,
                         @RequestParam String type,
                         @RequestParam String description){
        
        //Busco el language en cuestión
        Language language = languageService.findLanguage(id);
        
        //Esto tambien pude ir en service para desacoplar
        //mejor aun el codigo en un nuevo metodo
        language.setType(type);
        language.setDescription(description);
        
        languageService.saveLanguage(language);
        
        return "El lenguaje fue modificado correctamente";
    }    
    
    @DeleteMapping("/language/{id}")
    public String deleteLanguage(@PathVariable Long id){
        languageService.deleteLanguage(id);
        return "El language fue eliminado correctamente";
    }
    
    @GetMapping("/language/{id}")
    @ResponseBody
    public Language findLanguage(@PathVariable Long id) {
        return languageService.findLanguage(id);
    }
}
