package com.nicomarshal.portfolio.controller;

import com.nicomarshal.portfolio.dto.PersonDto;
import com.nicomarshal.portfolio.service.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    
    @Autowired
    private IPersonService personService;
    
    @GetMapping("/person")
    @ResponseBody
    public List<PersonDto> getPeople() {
        return personService.getPeople();
    }
    
    @PostMapping("/person")
    public String createPerson(@RequestBody PersonDto personDto){
        personService.createPerson(personDto);
        return "La persona fue creada correctamente";
    }
    
    @PutMapping("/person/{id}")
    public String editPerson(@PathVariable Long id, @RequestBody PersonDto personDto){
        
        personService.editPerson(id, personDto);
        return "La persona fue modificada correctamente";
    }    
    
    @DeleteMapping("/person/{id}")
    public String deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
        return "La persona fue eliminada correctamente";
    }
    
    @GetMapping("/person/{id}")
    @ResponseBody
    public PersonDto findPerson(@PathVariable Long id) {
        return personService.findPerson(id);
    }
}

