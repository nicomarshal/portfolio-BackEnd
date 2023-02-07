package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.dto.PersonDto;
import java.util.List;

public interface IPersonService {
    public List<PersonDto> getPeople();
    
    public void createPerson(PersonDto personDto);
    
    public void editPerson(Long id, PersonDto personDto);
    
    public void deletePerson(Long id);
    
    public PersonDto findPerson(Long id);
}
