package com.isw.nhr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

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
	@PutMapping("/edit/{idPersona}")
	public ResponseEntity<Persona> EditPersona(@RequestBody Persona persona){
		Persona per = personaService.SavePersona(persona);
		return new ResponseEntity<Persona>(per,HttpStatus.CREATED);

	}
	

	@GetMapping("/all")
	public  @ResponseBody List<Persona> allPersonas(){
		List<Persona> allPer = new ArrayList<>();
		personaService.listAll().forEach( (p)->
		
			{allPer.add(p);}
		);
		
	return allPer;
	}
	

	@DeleteMapping("/delete/{id}")
	public String RemovePersona(@PathVariable int id) {
		personaService.RemovePersona(Long.valueOf(id));
		return "Ok";		
	}

	
	

}
