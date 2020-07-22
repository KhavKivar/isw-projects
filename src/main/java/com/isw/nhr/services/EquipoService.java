package com.isw.nhr.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isw.nhr.model.Equipo;
import com.isw.nhr.repository.EquipoRepository;


@Service
public class EquipoService {
		@Autowired
		private EquipoRepository equipoRepository;
		public Equipo SaveOrUpdate(Equipo equipo) {
			return equipoRepository.save(equipo);
		}
		public Iterable<Equipo> listAll(){
			return equipoRepository.findAll();	
		}
		
		public void RemoveEquipo(Long id) {
			equipoRepository.deleteById(id);
			
		}

}
