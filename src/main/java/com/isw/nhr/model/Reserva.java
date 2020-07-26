package com.isw.nhr.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_reserva")
	private long idReserva;
	
	
	@Column(name = "fechainicial")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime FechaInicial;
	@Column(name = "fechatermino")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime FechaTermino;

	public Reserva() {}
	
	
	public Reserva(LocalDateTime fechaInicial, LocalDateTime fechaTermino) {
		super();
		FechaInicial = fechaInicial;
		FechaTermino = fechaTermino;
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
	
	
	public long getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}

	
}
