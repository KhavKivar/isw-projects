package com.isw.nhr.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.isw.nhr.model.Equipo;
import com.isw.nhr.repository.EquipoRepository;

public class EquipoService {
		@Autowired
		private EquipoRepository equipoRepository;
		public Equipo SaveOrUpdate(Equipo equipo) {
			return equipoRepository.save(equipo);
		}
		public Iterable<Equipo> listAll(){
			return equipoRepository.findAll();	
		}

}
