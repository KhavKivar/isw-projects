package com.isw.nhr.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.isw.nhr.model.Equipo;
import com.isw.nhr.model.Persona;
import com.isw.nhr.repository.PersonaRepository;

public class PersonaService {
	@Autowired
	private PersonaRepository personaRepository;
	
	
	public Persona SavePersona(Persona persona) {
		return personaRepository.save(persona);
		
	}
	public Iterable<Persona> listAll(){
		return personaRepository.findAll();	
	}

	
	
	
}
