package com.isw.nhr.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isw.nhr.model.Equipo;
import com.isw.nhr.model.Reserva;
import com.isw.nhr.model.Solicitud;
import com.isw.nhr.services.EquipoService;
import com.isw.nhr.services.ReservaService;

@CrossOrigin
@RestController

@RequestMapping("api/reservas")
public class ReservaController {
	@Autowired
	EquipoService equipoService;
	@Autowired
	ReservaService reservaService;
	

	@PostMapping("")
	public ResponseEntity<Equipo> addPersona(@RequestParam("fechainicio") String fechai,
			@RequestParam("fechatermino") String fechat,@RequestParam("idequipo") String idEquipo  ){
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		LocalDateTime fechainicial = LocalDateTime.parse(fechai, formatter);
		LocalDateTime fechatermino = LocalDateTime.parse(fechat, formatter);
		if(fechatermino.compareTo(fechainicial) <=0) {
			return null;	
			}
		
		Equipo eq = equipoService.findById(Long.valueOf(idEquipo)).get();
		Reserva rer = new Reserva(fechainicial,fechatermino);
		Set<Reserva> setrer = eq.getReservas();
		setrer.add(rer);
		
		eq.setReservas(setrer);
		
		
		Equipo resultado = equipoService.SaveOrUpdate(eq);
		
		
		
		return new ResponseEntity<Equipo>(resultado,HttpStatus.CREATED);

	}
	
	@DeleteMapping("/delete/{id}")
	public String RemoveReserva(@PathVariable int id) {
		reservaService.RemoveReserva(Long.valueOf(id));
		return "Ok";		
	}
	
}
