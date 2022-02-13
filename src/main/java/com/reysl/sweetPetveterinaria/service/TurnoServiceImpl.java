package com.reysl.sweetPetveterinaria.service;

import java.util.ArrayList;
import java.util.Optional;

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
	
	private boolean checkVetAvailable(Turno turno) throws Exception {	
		ArrayList<Turno> vetEncontrado = turnoRepository.findByVeterinario(turno.getVeterinario());
		if (!vetEncontrado.isEmpty()) {
			throw new Exception("El veterinario no está disponible");
		}
		
		return true;		
	}
	
	
	private boolean checkFechaAvailable(Turno turno) throws Exception {
		Optional <Turno> fechaEncontrada = turnoRepository.findByFecha(turno.getFecha());
		if(!fechaEncontrada.isEmpty()) {
			throw new Exception("La fecha no está disponible");
		}
		
		return true;
	}
	
	
	private boolean checkHorarioAvailable(Turno turno) throws Exception {
		Optional <Turno> horarioEncontrado = turnoRepository.findByHorario(turno.getHorario());
		if(!horarioEncontrado.isEmpty()) {
			throw new Exception("El horario no está disponible");
		}
		
		return true;
	}

	@Override
	public Turno crearTurno(Turno turno) throws Exception{
		if (checkVetAvailable(turno) || checkFechaAvailable(turno) || checkHorarioAvailable(turno)) {
			turno = turnoRepository.save(turno);
		}
		
		return turno;
	}

	@Override
	public Turno getTurnoById(Long id) throws Exception {
		return turnoRepository.findById(id).orElseThrow(() -> new Exception("El turno a editar no existe"));
	}

	@Override
	public Turno updateTurno(Turno fromTurno) throws Exception {
		Turno toTurno = getTurnoById(fromTurno.getId());
		mapTurno(fromTurno, toTurno);
		return turnoRepository.save(toTurno);
	}
	
	protected void mapTurno(Turno from, Turno to) {
		to.setEspecialidad(from.getEspecialidad());;
		to.setFecha(from.getFecha());;
		to.setHorario(from.getHorario());;
		to.setMascota(from.getMascota());;
		to.setVeterinario(from.getVeterinario());;
	}

	@Override
	public void deleteTurno(Long id) throws Exception {
		Turno turno = getTurnoById(id);
		turnoRepository.delete(turno);		
	}

	@Override
	public void deleteAllTurnos(String veterinario) {
		
		ArrayList<Turno> turnos = turnoRepository.findByVeterinario(veterinario);
		//Optional<Turno> turnos = turnoRepository.findByVeterinario(veterinario);
		
		for(int i=0; i<turnos.size();i++) {
			Turno turno = turnos.get(i);
			turnoRepository.delete(turno);
		}
		
	}

}
