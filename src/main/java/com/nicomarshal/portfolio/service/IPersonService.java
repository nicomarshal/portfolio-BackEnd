package com.nicomarshal.portfolio.service;

import java.util.List;
import com.nicomarshal.portfolio.model.Person;

public interface IPersonService {
    //Método para traer todas las personas
    public List<Person> getPeople();
    
    //Método para dar de alta una persona
    public void savePerson(Person person);
    
    //Método para eliminar una persona
    public void deletePerson(Long id);
    
    //Método para encontrar una persona
    public Person findPerson(Long id);
}
