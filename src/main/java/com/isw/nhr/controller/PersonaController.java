package com.isw.nhr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isw.nhr.model.Persona;
import com.isw.nhr.services.PersonaService;

@CrossOrigin
@RestController

@RequestMapping("api/personas")
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	@PostMapping("")
	public ResponseEntity<Persona> addPersona(@RequestBody Persona persona){
		Persona per = personaService.SavePersona(persona);
		return new ResponseEntity<Persona>(per,HttpStatus.CREATED);

	}
}
