package com.nicomarshal.portfolio.repository;

import com.nicomarshal.portfolio.model.SkillType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*La interface extiende de JpaRepository (que maneja reposi
torios JPA)
En los parámetros <>  deben ir: <clase a persistir, tipo de dato de su id>*/
@Repository
public interface ISkillTypeRepository extends JpaRepository<SkillType, Long> {    
}

