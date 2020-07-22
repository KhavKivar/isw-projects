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
	@Column(name="equipo_id")
	private long EquipoId;
	
	@ManyToMany
	@JoinTable(
			  name = "persona_equipo", 
			  joinColumns = @JoinColumn(name = "equipo_id",referencedColumnName = "equipo_id"), 
			  inverseJoinColumns = @JoinColumn(name = "persona_id",referencedColumnName = "persona_id") )
	
	
	private Set<Persona> ListaP =new HashSet<>();

	public long getEquipoId() {
		return EquipoId;
	}

	public void setEquipoId(long equipoId) {
		EquipoId = equipoId;
	}

	public Set<Persona> getListaP() {
		return ListaP;
	}

	public void setListaP(Set<Persona> listaP) {
		ListaP = listaP;
	}

	public Equipo(Set<Persona> listaP) {
		super();
		ListaP = listaP;
	}
	
	
	public Equipo() {}
	

}
