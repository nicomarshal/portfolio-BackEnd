package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.model.Person;
import com.nicomarshal.portfolio.repository.IPersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IPersonService {
    //Inyectamos dependencia
    @Autowired
    private IPersonRepository personRepository; 

    @Override
    public List<Person> getPeople() {
        List<Person> listPeople = personRepository.findAll();
        return listPeople;
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
        //Si no encuentra la persona, devuelve null(por esso va el orElse)
        Person person = personRepository.findById(id).orElse(null);
        return person;
    }
     
}
