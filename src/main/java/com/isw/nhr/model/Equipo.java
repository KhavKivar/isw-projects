package com.isw.nhr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "equipo")
public class Equipo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_equipo")
	private long IdEquipo;
	
	
	
	@ManyToMany
	@JoinTable(
			  name = "persona_equipo", 
			  joinColumns = @JoinColumn(name = "id_equipo",referencedColumnName = "id_equipo"), 
			  inverseJoinColumns = @JoinColumn(name = "id_persona",referencedColumnName = "id_persona") )
	
	
	private Set<Persona> Personas = new HashSet<>();

	
	
	private String NameEquipo;
	
	
		
	
	public String getNameEquipo() {
		return NameEquipo;
	}

	public void setNameEquipo(String nameEquipo) {
		NameEquipo = nameEquipo;
	}

	public long getIdEquipo() {
		return IdEquipo;
	}

	public void setIdEquipo(long idEquipo) {
		IdEquipo = idEquipo;
	}

	public Equipo(Set<Persona> personas) {
		super();
		Personas = personas;
	}

	public Set<Persona> getPersonas() {
		return Personas;
	}

	public void setPersonas(Set<Persona> personas) {
		Personas = personas;
	}

	public Equipo() {}
	

}
