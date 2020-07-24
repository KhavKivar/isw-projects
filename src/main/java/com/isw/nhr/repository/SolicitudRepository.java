package com.isw.nhr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isw.nhr.model.Solicitud;


@Repository
public interface SolicitudRepository extends CrudRepository<Solicitud,Long>{

}
