package com.isw.nhr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isw.nhr.model.Reserva;
import com.isw.nhr.model.Solicitud;
import com.isw.nhr.repository.ReservaRepository;
import com.isw.nhr.repository.SolicitudRepository;

@Service
public class SolicitudService {
	@Autowired
	SolicitudRepository solicitudRepository;
	
	
	public Solicitud SaveOrUpdate(Solicitud solicitud) {
		return solicitudRepository.save(solicitud)
				;
	}
	
	
	public Iterable<Solicitud> listAll(){
		return solicitudRepository.findAll();
	}
	
	public void RemoveSolicitud(Long id) {
		solicitudRepository.deleteById(id);
		
	}

}
