package com.nicomarshal.portfolio.controller;

import com.nicomarshal.portfolio.model.Person;
import com.nicomarshal.portfolio.service.IPersonService;
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
public class PersonController {
    
    @Autowired
    private IPersonService personService;
    
    @GetMapping("/person")
    @ResponseBody
    public List<Person> getPeople() {
        return personService.getPeople();
    }
    
    @PostMapping("/person")
    public String createPerson(@RequestBody Person person){
        personService.savePerson(person);
        return "La persona fue creada correctamente";
    }
    
    @PutMapping("/person/{id}")
    public String editPerson(@PathVariable Long id,
                         @RequestParam String profileImg,
                         @RequestParam String name,
                         @RequestParam String surname,
                         @RequestParam String profession,
                         @RequestParam String aboutMe){
        
        //Busco la persona en cuestión
        Person person = personService.findPerson(id);
        
        //Esto tambien pude ir en service para desacoplar
        //mejor aun el codigo en un nuevo metodo
        person.setProfileImg(profileImg);
        person.setName(name);
        person.setSurname(surname);
        person.setProfession(profession);
        person.setAboutMe(aboutMe);
        
        personService.savePerson(person);
        
        return "La persona fue modificada correctamente";
    }    
    
    @DeleteMapping("/person/{id}")
    public String deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
        return "La persona fue eliminada correctamente";
    }
    
    @GetMapping("/person/{id}")
    @ResponseBody
    public Person findPerson(@PathVariable Long id) {
        return personService.findPerson(id);
    }
}

