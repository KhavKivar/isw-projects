package com.isw.nhr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isw.nhr.model.Reserva;

@Repository
public interface ReservaRepository  extends CrudRepository<Reserva,Long>{

}
