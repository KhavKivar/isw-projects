package com.isw.nhr.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isw.nhr.model.Equipo;
import com.isw.nhr.model.Persona;
import com.isw.nhr.repository.PersonaRepository;


@Service
public class PersonaService {
	
	
	@Autowired
	private PersonaRepository personaRepository;
	
	
	public Persona SavePersona(Persona persona) {
		return personaRepository.save(persona);
		
	}
	public Iterable<Persona> listAll(){
		return personaRepository.findAll();	
	}
	
	public Optional<Persona> FindPersona(long id) {
		
		
		return personaRepository.findById(id);
	
	}

	
	
}
