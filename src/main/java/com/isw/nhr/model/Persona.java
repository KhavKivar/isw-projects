package com.isw.nhr.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_persona")
	private long IdPersona;
	private String Nombre;
	private String Apellido;
	
	private int Identificador;
	
	private String Especializacion;
	private int Estado;
	
	@ManyToMany(mappedBy = "Personas")
	private Set<Equipo> ListaEq = new HashSet<>();
	
	
	
	
	public Persona(String nombre, String apellido, int identificador, String especializacion, int estado) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		Identificador = identificador;
		Especializacion = especializacion;
		Estado = estado;
	}


	public int getIdentificador() {
		return Identificador;
	}


	public void setIdentificador(int identificador) {
		Identificador = identificador;
	}


	public Persona() {}
	
	
	



	public long getIdPersona() {
		return IdPersona;
	}


	public void setIdPersona(long idPersona) {
		IdPersona = idPersona;
	}


	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	
	
	
	public String getEspecializacion() {
		return Especializacion;
	}
	public void setEspecializacion(String especializacion) {
		Especializacion = especializacion;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
		Estado = estado;
	}
	
	
	
}
