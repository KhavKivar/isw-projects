package com.isw.nhr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isw.nhr.model.Equipo;
import com.isw.nhr.model.Reserva;
import com.isw.nhr.repository.ReservaRepository;

@Service
public class ReservaService {
	@Autowired
	ReservaRepository reservaRepository;
	
	@Autowired
	private EquipoService equipoService;
	

	public Reserva SaveOrUpdate(Reserva reserva) {
		return reservaRepository.save(reserva);
	}
	
	
	public Iterable<Reserva> listAll(){
		return reservaRepository.findAll();
	}
	
	public void RemoveReserva(Long id) {
		reservaRepository.deleteById(id);
		
	}
	
	
}
