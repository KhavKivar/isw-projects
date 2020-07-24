package com.isw.nhr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.isw.nhr.model.Equipo;
import com.isw.nhr.model.Persona;
import com.isw.nhr.services.EquipoService;
import com.isw.nhr.services.PersonaService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@CrossOrigin
@RestController
@RequestMapping("api/equipos")
public class EquipoController {
	@Autowired
	private EquipoService equipoService;
	@Autowired
	private PersonaService personaService;
	
	@PostMapping("")
	public ResponseEntity<Equipo> addEquipo(
			@RequestParam("Id") List<String> Ids,@RequestParam("Name") String name ){
			
		Set<Persona>  personas = new HashSet<>();
		for(String id:Ids) {
			Persona p = personaService.FindByIdentificador(Long.valueOf(id));
			if(p !=null) {
				personas.add(p);
			}
		}
		
		Equipo neq = new Equipo();
		neq.setPersonas(personas);
		neq.setNameEquipo(name);
		equipoService.SaveOrUpdate(neq);
		return new ResponseEntity<Equipo>(neq,HttpStatus.CREATED);
		

	}
	
	
	@DeleteMapping("/delete/{id}")
	public String RemoveEquipo(@PathVariable int id) {
		equipoService.RemoveEquipo(Long.valueOf(id));
		return "Ok";		
	}
	
	
	
	
	@PostMapping("/all")
	public  @ResponseBody List<Equipo> allEquipo(){
		List<Equipo> allEq= new ArrayList<>();
		equipoService.listAll().forEach( (eq)-> {allEq.add(eq);  } );
		return allEq;
	}
	
	
	
	
	@PostMapping("/edit")
	public ResponseEntity<Equipo> EditEquipo(
			@RequestParam("Id") List<String> Ids,@RequestParam("Name") String name,
			@RequestParam("IdEquipo") String idEquipo
			){
		
		Set<Persona>  personas = new HashSet<>();
		for(String id:Ids) {
			Persona p = personaService.FindByIdentificador(Long.valueOf(id));
			if(p !=null) {
				personas.add(p);
			}
		}
		
		Equipo neq = new Equipo();
		neq.setIdEquipo(Long.valueOf(idEquipo));
		neq.setNameEquipo(name);
		neq.setPersonas(personas);
		
		equipoService.SaveOrUpdate(neq);
		
		
		return new ResponseEntity<Equipo>(neq,HttpStatus.CREATED);

	}
		
	

}
