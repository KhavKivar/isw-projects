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
	@Column(name="persona_id")
	private long PersonaId;
	private String Nombre;
	private String Apellido;
	private long Dau;
	private String Especializacion;
	private int Estado;
	
	@ManyToMany(mappedBy = "ListaP")
	private Set<Equipo> ListaEq = new HashSet<>();
	
	
	
	public Persona(String nombre, String apellido, long dau, String especializacion, int estado) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		Dau = dau;
		Especializacion = especializacion;
		Estado = estado;
	}
	
	public Persona() {}
	
	
	public long getPersonaId() {
		return PersonaId;
	}

	public void setPersonaId(long personaId) {
		PersonaId = personaId;
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
	public long getDau() {
		return Dau;
	}
	public void setDau(long dau) {
		Dau = dau;
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
