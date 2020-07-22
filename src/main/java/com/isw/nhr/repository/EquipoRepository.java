package com.isw.nhr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isw.nhr.model.Equipo;

@Repository
public interface EquipoRepository extends CrudRepository<Equipo,Long>{

}
