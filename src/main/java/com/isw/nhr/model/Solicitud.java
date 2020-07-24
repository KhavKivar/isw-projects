package com.isw.nhr.model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "solicitud")

public class Solicitud {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_solicitud")
	private long idSolicitud;
	

	@Column(name = "fechainicial")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime FechaInicial;
	@Column(name = "fechatermino")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime FechaTermino;
	
	

	
	
	
	
	public Solicitud(LocalDateTime fechaInicial, LocalDateTime fechaTermino) {
		super();
		FechaInicial = fechaInicial;
		FechaTermino = fechaTermino;
	}






	public long getIdSolicitud() {
		return idSolicitud;
	}






	public void setIdSolicitud(long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}






	public LocalDateTime getFechaInicial() {
		return FechaInicial;
	}






	public void setFechaInicial(LocalDateTime fechaInicial) {
		FechaInicial = fechaInicial;
	}






	public LocalDateTime getFechaTermino() {
		return FechaTermino;
	}






	public void setFechaTermino(LocalDateTime fechaTermino) {
		FechaTermino = fechaTermino;
	}










	public Solicitud() {
		
	}

}
