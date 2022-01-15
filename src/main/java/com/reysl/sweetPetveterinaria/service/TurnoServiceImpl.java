package com.reysl.sweetPetveterinaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reysl.sweetPetveterinaria.entity.Turno;
import com.reysl.sweetPetveterinaria.repository.TurnoRepository;

@Service
public class TurnoServiceImpl implements TurnoService{
	
	@Autowired
	TurnoRepository turnoRepository;
	
	@Override
	public Iterable<Turno> getAllTurnos() {
		return turnoRepository.findAll();
	}

	@Override
	public Turno crearTurno(Turno turno) {
		turno = turnoRepository.save(turno);
		return turno;
	}

}
