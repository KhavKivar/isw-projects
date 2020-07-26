package com.isw.nhr.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import com.isw.nhr.model.Equipo;
import com.isw.nhr.model.Reserva;
import com.isw.nhr.model.Solicitud;
import com.isw.nhr.services.EquipoService;
import com.isw.nhr.services.SolicitudService;

@CrossOrigin
@RestController

@RequestMapping("api/solicitudes")
public class SolicitudController {
	@Autowired
	SolicitudService solicitudService;
	@Autowired
	private EquipoService equipoService;
	
	@PostMapping("")
	
	
	public ResponseEntity<Equipo> addPersona(@RequestParam("fechainicio") String fechai,
			@RequestParam("fechatermino") String fechat,@RequestParam("idequipo") String idEquipo  ){
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		LocalDateTime fechainicial = LocalDateTime.parse(fechai, formatter);
		LocalDateTime fechatermino = LocalDateTime.parse(fechat, formatter);

		Equipo eq = equipoService.findById(Long.valueOf(idEquipo)).get();
		if(fechatermino.compareTo(fechainicial) <=0) {
		return null;	
		}
		
		//Verificamos si hay una reserva en conflicto
		for(Reserva x:eq.getReservas()) {
			if( (fechainicial.compareTo(x.getFechaInicial())  >= 0  && fechainicial.compareTo(x.getFechaTermino()) <= 0 ) ||
					
					( fechatermino.compareTo(x.getFechaInicial()) >= 0 && fechatermino.compareTo(x.getFechaTermino()) <= 0) )
					 {
				return null;
		}
		}
		
		Solicitud sol = new Solicitud(fechainicial,fechatermino);
		Set<Solicitud> setsol = eq.getSolicitudes();
		setsol.add(sol);
		
		eq.setSolicitudes(setsol);
		
		
		Equipo resultado = equipoService.SaveOrUpdate(eq);
		
		
		
		return new ResponseEntity<Equipo>(resultado,HttpStatus.CREATED);

	}
	
	@GetMapping("/all")
	public  @ResponseBody List<Solicitud> allSolicitudes(){
		List<Solicitud> allSol = new ArrayList<>();
		solicitudService.listAll().forEach((sol) -> 
		{allSol.add(sol);}) ;
		return allSol;
	}
	
	@DeleteMapping("/delete/{id}")
	public String RemoveSolicitud(@PathVariable int id) {
		solicitudService.RemoveSolicitud(Long.valueOf(id));
		return "Ok";		
	}

	@PostMapping("/accept/{id}")
	public @ResponseBody Equipo aceptarSolicitud(@PathVariable int id){
		//Hay buscar el equipo que tiene la id_solicitud
		Iterator<Equipo> it = equipoService.listAll().iterator();
		Equipo equipo = null;


		while(it.hasNext()) {
			Equipo aux = it.next();
			for(Solicitud solicitud: aux.getSolicitudes()){
				if(solicitud.getIdSolicitud() == id){
					Set<Reserva> rer = aux.getReservas();
					Reserva rrnew = new Reserva(solicitud.getFechaInicial(),solicitud.getFechaTermino());
					rer.add(rrnew);
					Set<Solicitud> sol = aux.getSolicitudes();
					sol.remove(solicitud);
					aux.setReservas(rer);
					aux.setSolicitudes(sol);
					equipoService.SaveOrUpdate(aux);
					solicitudService.RemoveSolicitud(Long.valueOf(id));
					equipo = aux;
					break;

				}

			}
		
		}
		

		return equipo;
	}
	 
	
	
}
