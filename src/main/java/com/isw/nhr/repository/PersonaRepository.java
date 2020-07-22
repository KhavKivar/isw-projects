package com.isw.nhr.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isw.nhr.model.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona,Long>{

}
