package com.isw.nhr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "equipo")


public class Equipo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_equipo")
	private long idEquipo;
	
	private String nameEquipo;
	
	@ManyToMany
	@JoinTable(
			  name = "persona_equipo", 
			  joinColumns = @JoinColumn(name = "id_equipo",referencedColumnName = "id_equipo"), 
			  inverseJoinColumns = @JoinColumn(name = "id_persona",referencedColumnName = "id_persona") )
	private Set<Persona> personas = new HashSet<>();
	
	
    @OneToMany(targetEntity=Solicitud.class,cascade=CascadeType.ALL)
    @JoinColumn(name="id_equipo",referencedColumnName="id_equipo")
    private Set<Solicitud> Solicitudes = new HashSet<>();

	
    @OneToMany(targetEntity=Reserva.class,cascade=CascadeType.ALL)
    @JoinColumn(name="id_equipo",referencedColumnName="id_equipo")
    private Set<Reserva> Reservas = new HashSet<>();
    
    
    private String director="";
    
    private int integrantes=0;
    
    
	
 
	public String getDirector() {
		return director;
	}






	public void setDirector(String director) {
		this.director = director;
	}






	public int getIntegrantes() {
		return integrantes;
	}






	public void setIntegrantes(int integrantes) {
		this.integrantes = integrantes;
	}






	public Equipo() {}

	

	
	

	public Set<Reserva> getReservas() {
		return Reservas;
	}








	public void setReservas(Set<Reserva> reservas) {
		Reservas = reservas;
	}








	public Set<Solicitud> getSolicitudes() {
		return Solicitudes;
	}






	public void setSolicitudes(Set<Solicitud> solicitudes) {
		Solicitudes = solicitudes;
	}






	




	public Equipo(String nameEquipo, Set<Persona> personas, Set<Solicitud> solicitudes, Set<Reserva> reservas,
			String director, int integrantes) {
		super();
		this.nameEquipo = nameEquipo;
		this.personas = personas;
		Solicitudes = solicitudes;
		Reservas = reservas;
		this.director = director;
		this.integrantes = integrantes;
	}






	public long getIdEquipo() {
		return idEquipo;
	}





	public void setIdEquipo(long idEquipo) {
		this.idEquipo = idEquipo;
	}





	public Set<Persona> getPersonas() {
		return personas;
	}





	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}





	public String getNameEquipo() {
		return nameEquipo;
	}





	public void setNameEquipo(String nameEquipo) {
		this.nameEquipo = nameEquipo;
	}





	
	

}
