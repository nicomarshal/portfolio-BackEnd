package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.dto.PersonDto;
import com.nicomarshal.portfolio.model.Person;
import com.nicomarshal.portfolio.model.User;
import com.nicomarshal.portfolio.repository.IPersonRepository;
import com.nicomarshal.portfolio.repository.IUserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {
    @Autowired
    private IPersonRepository personRepository;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<PersonDto> getPeople() {
        List<Person> listPeople = personRepository.findAll();
        
        List<PersonDto> listPeopleDto = new ArrayList<>();
        
        for (Person person : listPeople) {
            PersonDto personDto = new PersonDto();
            
            //Mapeo
            personDto.setProfileImg(person.getProfileImg());
            personDto.setName(person.getName());
            personDto.setSurname(person.getSurname());
            personDto.setProfession(person.getProfession());
            personDto.setAboutMe(person.getAboutMe());
            personDto.setUserId(person.getUser().getId());
            
            listPeopleDto.add(personDto);
        }       
        return listPeopleDto;
    }

    @Override
    public void createPerson(PersonDto personDto) {
        Long userId = personDto.getUserId();     
        User user = userRepository.findById(userId).orElse(null);
        
        Person person = new Person();
        
        //Mapeo
        person.setProfileImg(personDto.getProfileImg());
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());
        person.setProfession(personDto.getProfession());
        person.setAboutMe(personDto.getAboutMe());
        person.setUser(user);
        
        personRepository.save(person);
    }
    
    @Override
    public void editPerson(Long id, PersonDto personDto) {
        Long userId = personDto.getUserId();     
        User user = userRepository.findById(userId).orElse(null);
        
        Person person = personRepository.findById(id).orElse(null);
        
        //Mapeo
        person.setProfileImg(personDto.getProfileImg());
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());
        person.setProfession(personDto.getProfession());
        person.setAboutMe(personDto.getAboutMe());
        person.setUser(user);
        
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public PersonDto findPerson(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        
        PersonDto personDto = new PersonDto();
        
        //Mapeo
        personDto.setProfileImg(person.getProfileImg());
        personDto.setName(person.getName());
        personDto.setSurname(person.getSurname());
        personDto.setProfession(person.getProfession());
        personDto.setAboutMe(person.getAboutMe());
        personDto.setUserId(person.getUser().getId());
            
        return personDto;
    }  
}
